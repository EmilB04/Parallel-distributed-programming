# run.sh - Runs a specified Java class using MPJ Express with the given number of processes and arguments.

#!/usr/bin/env bash
set -euo pipefail

if [[ $# -lt 2 ]]; then
  echo "Usage: ./scripts/run.sh <np> <ClassName> [class args...]"
  echo "Examples:"
  echo "  ./scripts/run.sh 4 HelloWorld"
  echo "  ./scripts/run.sh 2 Echo"
  echo "  ./scripts/run.sh 4 MatrixMatrixMult 512"
  exit 1
fi

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
MPJ_DIR="${PROJECT_ROOT}/.tools/mpj-v0_44"

if [[ ! -d "${MPJ_DIR}" ]]; then
  echo "MPJ Express not found. Run ./scripts/setup-mpj.sh first."
  exit 1
fi

NP="$1"
CLASS_NAME="$2"
shift 2

if [[ ! -d "${PROJECT_ROOT}/out" ]]; then
  echo "No compiled classes found. Run ./scripts/compile.sh first."
  exit 1
fi

export MPJ_HOME="${MPJ_DIR}"

"${MPJ_DIR}/bin/mpjrun.sh" -np "${NP}" -cp "${PROJECT_ROOT}/out" "${CLASS_NAME}" "$@"
