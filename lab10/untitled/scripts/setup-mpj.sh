# setup-mpj.sh - Downloads and sets up MPJ Express for the project.

#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
TOOLS_DIR="${PROJECT_ROOT}/.tools"
MPJ_DIR="${TOOLS_DIR}/mpj-v0_44"
DOWNLOAD_URL="https://downloads.sourceforge.net/project/mpjexpress/releases/mpj-v0_44.tar.gz"
ARCHIVE_PATH="${TOOLS_DIR}/mpj-v0_44.tar.gz"

mkdir -p "${TOOLS_DIR}"

if [[ -d "${MPJ_DIR}" ]]; then
  echo "MPJ Express already installed at ${MPJ_DIR}"
  exit 0
fi

echo "Downloading MPJ Express..."
curl -L "${DOWNLOAD_URL}" -o "${ARCHIVE_PATH}"

echo "Extracting MPJ Express..."
tar -xzf "${ARCHIVE_PATH}" -C "${TOOLS_DIR}"

echo "MPJ Express installed at ${MPJ_DIR}"
echo "You can now run ./scripts/compile.sh"
