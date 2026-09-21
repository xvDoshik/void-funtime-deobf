#!/usr/bin/env python3
from __future__ import annotations

import argparse
import json
import re
import shutil
import subprocess
import sys
import urllib.request
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent
DEFAULT_JAR = ROOT / "Void-1.1.1.jar"
DEFAULT_CFR = ROOT.parent / "mod" / "cfr.jar"
CACHE = ROOT / ".cache"
JAVA_CANDIDATES = (
    Path("/opt/homebrew/opt/openjdk@21/bin/java"),
    Path("/opt/homebrew/opt/openjdk@17/bin/java"),
    Path("/opt/homebrew/opt/openjdk/bin/java"),
    Path("/usr/bin/java"),
)
YARN_VER = "1.21.4+build.8"
YARN_TINY = CACHE / f"yarn-{YARN_VER}.tiny"
YARN_URL = f"https://maven.fabricmc.net/net/fabricmc/yarn/{YARN_VER}/yarn-{YARN_VER}-v2.jar"


def log(msg: str) -> None:
    print(msg, flush=True)


def ensure_yarn_tiny(force: bool) -> Path | None:
    if YARN_TINY.is_file() and not force:
        return YARN_TINY
    CACHE.mkdir(parents=True, exist_ok=True)
    jar_path = CACHE / f"yarn-{YARN_VER}.jar"
    try:
        log(f"download yarn {YARN_VER}")
        urllib.request.urlretrieve(YARN_URL, jar_path)
        with zipfile.ZipFile(jar_path) as zf:
            tiny_name = next(n for n in zf.namelist() if n.endswith(".tiny"))
            YARN_TINY.write_bytes(zf.read(tiny_name))
        return YARN_TINY
    except Exception as exc:
        log(f"yarn skip: {exc}")
        return None


def parse_tiny(path: Path) -> tuple[dict[str, str], dict[str, str]]:
    classes: dict[str, str] = {}
    methods: dict[str, str] = {}
    if not path.is_file():
        return classes, methods
    current_class = ""
    for raw in path.read_text(encoding="utf-8", errors="replace").splitlines():
        if not raw or raw.startswith("#"):
            continue
        if raw.startswith("\t"):
            continue
        parts = raw.split("\t")
        if parts[0] == "c" and len(parts) >= 3:
            inter, named = parts[1], parts[2]
            current_class = inter.rsplit("/", 1)[-1]
            if inter.startswith("net/minecraft/") and named.startswith("net/minecraft/"):
                classes[current_class] = named.rsplit("/", 1)[-1]
            continue
        if parts[0] == "m" and len(parts) >= 5:
            imethod, nmethod = parts[3], parts[4]
            if current_class and imethod != nmethod:
                methods[f"{current_class}.{imethod}"] = nmethod
    return classes, methods


def extract_jar(jar: Path, out: Path) -> None:
    if out.is_dir():
        shutil.rmtree(out)
    out.mkdir(parents=True)
    with zipfile.ZipFile(jar) as zf:
        zf.extractall(out)


def find_java() -> str:
    for p in JAVA_CANDIDATES:
        if p.is_file():
            return str(p)
    return "java"


def collect_class_targets(extracted: Path, scope: str, refmap: dict | None = None) -> list[Path]:
    targets: set[str] = set()
    if refmap:
        for mixin_cls in refmap:
            if isinstance(mixin_cls, str):
                targets.add(mixin_cls.replace(".", "/") + ".class")
    mixins_path = extracted / "void.mixins.json"
    mixin_pkg = "CLASSESS"
    if mixins_path.is_file():
        mj = json.loads(mixins_path.read_text(encoding="utf-8"))
        mixin_pkg = mj.get("package") or mixin_pkg
        for key in ("mixins", "client", "server"):
            for name in mj.get(key) or []:
                if isinstance(name, str):
                    targets.add(f"{mixin_pkg.replace('.', '/')}/{name}.class")
    fabric_path = extracted / "fabric.mod.json"
    if fabric_path.is_file():
        meta = json.loads(fabric_path.read_text(encoding="utf-8"))
        for classes in (meta.get("entrypoints") or {}).values():
            for cls in classes or []:
                if isinstance(cls, str):
                    targets.add(cls.replace(".", "/") + ".class")
    if scope == "all":
        for p in extracted.rglob("*.class"):
            rel = p.relative_to(extracted).as_posix()
            if rel.startswith("META-INF/jars/"):
                continue
            if rel.startswith("CLASSESS/") or rel.startswith("LABMA/"):
                targets.add(rel)
    out_paths = []
    for rel in sorted(targets):
        p = extracted / rel
        if p.is_file():
            out_paths.append(p)
    return out_paths


def run_cfr(classes: list[Path], cfr: Path, out: Path, heap: str) -> None:
    if out.is_dir():
        shutil.rmtree(out)
    out.mkdir(parents=True)
    if not classes:
        log("cfr: no classes")
        return
    java = find_java()
    log(f"cfr decompile {len(classes)} classes…")
    ok = 0
    fail = 0
    for i, cls in enumerate(classes, 1):
        cmd = [
            java,
            f"-Xmx{heap}",
            "-jar",
            str(cfr),
            str(cls),
            "--outputdir",
            str(out),
            "--caseinsensitivefs",
            "true",
            "--silent",
            "true",
        ]
        try:
            subprocess.run(cmd, check=True, capture_output=True)
            ok += 1
        except subprocess.CalledProcessError:
            fail += 1
        if i % 50 == 0:
            log(f"cfr progress {i}/{len(classes)} ok={ok} fail={fail}")
    log(f"cfr done ok={ok} fail={fail}")


def load_refmap(extracted: Path) -> dict:
    p = extracted / "Void-refmap.json"
    if not p.is_file():
        return {}
    data = json.loads(p.read_text(encoding="utf-8"))
    return data.get("mappings") or {}


def refmap_to_named(refmap: dict, class_map: dict[str, str]) -> list[dict]:
    rows = []
    for mixin_cls, methods in refmap.items():
        if not isinstance(methods, dict):
            continue
        for obf_method, desc in methods.items():
            named_desc = desc
            for short, yarn in sorted(class_map.items(), key=lambda x: -len(x[0])):
                named_desc = named_desc.replace(short, yarn)
            rows.append(
                {
                    "mixin": mixin_cls,
                    "obf_method": obf_method,
                    "intermediary": desc,
                    "hint": named_desc,
                }
            )
    return rows


def apply_yarn_to_sources(src_root: Path, class_map: dict[str, str]) -> Path:
    named_root = src_root.parent / "named"
    if named_root.is_dir():
        shutil.rmtree(named_root)
    shutil.copytree(src_root, named_root)
    pattern = re.compile(r"\b(class_\d+)\b")
    for path in named_root.rglob("*.java"):
        text = path.read_text(encoding="utf-8", errors="replace")
        def repl(m: re.Match) -> str:
            key = m.group(1)
            return class_map.get(key, key)

        new_text = pattern.sub(repl, text)
        path.write_text(new_text, encoding="utf-8")
    return named_root


def write_reports(
    reports: Path,
    refmap_rows: list[dict],
    extracted: Path,
    fabric_meta: dict,
) -> None:
    reports.mkdir(parents=True, exist_ok=True)
    (reports / "mixin_refmap.json").write_text(
        json.dumps(refmap_rows, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )
    for name in ("void.accesswidener", "void.mixins.json", "void-compat.mixins.json", "fabric.mod.json"):
        src = extracted / name
        if src.is_file():
            shutil.copy2(src, reports / name)
    mixins = []
    mp = extracted / "void.mixins.json"
    if mp.is_file():
        mixins = json.loads(mp.read_text(encoding="utf-8"))
    lines = [
        "# Void deobfuscation report",
        "",
        f"- mod: {fabric_meta.get('name', '?')} {fabric_meta.get('version', '?')}",
        f"- minecraft: {fabric_meta.get('depends', {}).get('minecraft', '?')}",
        f"- mixin classes in refmap: {len(refmap_rows)}",
        "",
        "## Mixin → Minecraft (from refmap + yarn)",
        "",
    ]
    by_mixin: dict[str, list] = {}
    for row in refmap_rows:
        by_mixin.setdefault(row["mixin"], []).append(row)
    for mixin_cls in sorted(by_mixin.keys()):
        lines.append(f"### `{mixin_cls}`")
        for row in by_mixin[mixin_cls]:
            lines.append(f"- `{row['obf_method']}` → `{row['hint']}`")
        lines.append("")
    if isinstance(mixins, dict):
        client = mixins.get("client") or []
        if client:
            lines.append("## Client mixin class names (obfuscated)")
            lines.append("")
            lines.append(", ".join(f"`{x}`" for x in client))
            lines.append("")
    (reports / "SUMMARY.md").write_text("\n".join(lines), encoding="utf-8")


def annotate_entrypoints(decompiled: Path, extracted: Path) -> None:
    fabric_path = extracted / "fabric.mod.json"
    if not fabric_path.is_file():
        return
    meta = json.loads(fabric_path.read_text(encoding="utf-8"))
    eps = meta.get("entrypoints") or {}
    for kind, classes in eps.items():
        for cls in classes or []:
            rel = cls.replace(".", "/") + ".java"
            for base in (decompiled, decompiled.parent / "named"):
                target = base / rel
                if not target.is_file():
                    continue
                head = f"// void entrypoint: {kind} {cls}\n"
                body = target.read_text(encoding="utf-8", errors="replace")
                if not body.startswith("// void entrypoint"):
                    target.write_text(head + body, encoding="utf-8")


def main() -> int:
    ap = argparse.ArgumentParser(description="Deobfuscate Void Fabric mod jar")
    ap.add_argument("--jar", type=Path, default=DEFAULT_JAR)
    ap.add_argument("--cfr", type=Path, default=DEFAULT_CFR)
    ap.add_argument("--out", type=Path, default=ROOT / "out")
    ap.add_argument("--no-yarn", action="store_true")
    ap.add_argument("--refresh-yarn", action="store_true")
    ap.add_argument("--skip-cfr", action="store_true")
    ap.add_argument(
        "--scope",
        choices=("mixins", "all"),
        default="mixins",
        help="mixins=entrypoints+mixin classes; all=whole CLASSESS/LABMA (slow)",
    )
    ap.add_argument("--heap", default="2g", help="Java heap for CFR, e.g. 4g")
    args = ap.parse_args()

    if not args.jar.is_file():
        log(f"missing jar: {args.jar}")
        return 2
    if not args.skip_cfr and not args.cfr.is_file():
        log(f"missing cfr: {args.cfr}")
        return 2

    out = args.out
    extracted = out / "extracted"
    decompiled = out / "decompiled"
    reports = out / "reports"

    log(f"jar {args.jar}")
    extract_jar(args.jar, extracted)

    class_map: dict[str, str] = {}
    if not args.no_yarn:
        tiny = ensure_yarn_tiny(args.refresh_yarn)
        if tiny:
            class_map, _ = parse_tiny(tiny)
            log(f"yarn classes {len(class_map)}")

    reports.mkdir(parents=True, exist_ok=True)
    refmap = load_refmap(extracted)
    class_targets = collect_class_targets(extracted, args.scope, refmap)
    (reports / "decompile_targets.txt").write_text(
        "\n".join(p.relative_to(extracted).as_posix() for p in class_targets),
        encoding="utf-8",
    )
    if not args.skip_cfr:
        run_cfr(class_targets, args.cfr, decompiled, args.heap)

    refmap_rows = refmap_to_named(refmap, class_map)
    fabric_meta = {}
    fp = extracted / "fabric.mod.json"
    if fp.is_file():
        fabric_meta = json.loads(fp.read_text(encoding="utf-8"))

    reports.mkdir(parents=True, exist_ok=True)
    if class_map and decompiled.is_dir():
        named = apply_yarn_to_sources(decompiled, class_map)
        annotate_entrypoints(named, extracted)
        log(f"named sources {named}")
    annotate_entrypoints(decompiled, extracted)

    write_reports(reports, refmap_rows, extracted, fabric_meta)
    log(f"extracted → {extracted}")
    log(f"decompiled → {decompiled}")
    log(f"reports → {reports / 'SUMMARY.md'}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
