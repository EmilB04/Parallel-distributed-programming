# compile.sh - Compiles the Java source files using MPJ Express.

#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
MPJ_DIR="${PROJECT_ROOT}/.tools/mpj-v0_44"

if [[ ! -d "${MPJ_DIR}" ]]; then
  echo "MPJ Express not found. Run ./scripts/setup-mpj.sh first."
  exit 1
fi

cd "${PROJECT_ROOT}"
mkdir -p out

javac -cp "${MPJ_DIR}/lib/mpj.jar" -d out src/*.java

echo "Compilation complete. Classes are in out/."
