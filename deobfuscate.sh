#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
JAR="${1:-Void-1.1.1.jar}"
shift || true
exec python3 deobfuscate_void.py --jar "$JAR" --scope mixins --heap 2g "$@"
