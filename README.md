EN | [RU](docs/README_RU.md)

## void-funtime-deobf 🔓

![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-62B47A?style=flat-square)

**Void Modification** (Funtime / Fabric) — bundled original JAR, CFR decompile output, Yarn-backed mixin reports, and a local deobfuscation pipeline.

| Artifact | Version |
|----------|---------|
| Mod JAR | `Void-1.1.1.jar` (Git LFS) |
| Minecraft | `~1.21.4` |
| Tag | `void-mod-1.1.1` pins the shipped binary |

Mixin map: [out/reports/SUMMARY.md](out/reports/SUMMARY.md)

---

## ⚠️ Publishing — your risk only

Funtime-adjacent cheat communities (Telegram, Discord, repacks) are hostile: scams, malware-laced “cracks”, harassment, takedowns, and legal exposure. **Do not push this to a public host lightly.** Prefer private forks, lab VMs, and no personal accounts in metadata. See [RU warning](docs/README_RU.md#-публикация--только-на-свой-страх-и-риск) for detail.

---

## ✨ Highlights

| | |
|---|---|
| **Original JAR** | `Void-1.1.1.jar` in repo (LFS) |
| **Decompile** | `out/decompiled/` + Yarn-renamed `out/named/` (mixin scope sample) |
| **Reports** | Refmap → Minecraft hints, `fabric.mod.json`, mixins JSON |
| **Pipeline** | `deobfuscate_void.py` — extract, CFR, Yarn 1.21.4+build.8 |

---

## 🚀 Quick start

```bash
git clone <url>
cd void-funtime-deobf
git lfs pull

chmod +x deobfuscate.sh
./deobfuscate.sh
```

Requires **Python 3.10+**, **Java 17+** (21 recommended), **[CFR](https://www.benf.org/other/cfr/)** (`--cfr` or `../mod/cfr.jar`).

Full mod tree (slow):

```bash
python3 deobfuscate_void.py --scope all --heap 8g
```

---

## 📁 Structure

```
Void-1.1.1.jar          original mod (Git LFS)
deobfuscate_void.py     pipeline
deobfuscate.sh          wrapper (--scope mixins)
out/decompiled/         CFR output
out/named/              class_NNN → Yarn names
out/reports/            SUMMARY.md, refmap, mixins
```

`out/extracted/` is gitignored (regenerate from JAR).

---

## 🔒 Security

- Treat the JAR as **untrusted closed-source**; audit network/exec before running in-game.
- Decompiled code is for **RE in a lab**, not for bypassing server rules.
- Do not commit `.cache/` or full `out/extracted/` (large, redundant).

---

## 📜 License

| Component | License |
|-----------|---------|
| Scripts & docs in this repo | [MIT](LICENSE) — © 2026 xvDosha |
| **Void Modification** (`Void-1.1.1.jar`, decompiled mod bytecode) | **All rights reserved** — author **fokori** (see `out/reports/fabric.mod.json`). Not granted under MIT. |

---

## 🏷️ Tags

| Tag | Meaning |
|-----|---------|
| `v1.0.0` | First release of this archive (toolchain + mixin decompile + JAR) |
| `void-mod-1.1.1` | Same tree; marks **Void Modification 1.1.1** binary |
