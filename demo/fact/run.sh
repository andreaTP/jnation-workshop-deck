#! /bin/bash
set -euxo pipefail

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

export WASMTIME_NEW_CLI=0

${SCRIPT_DIR}/../chicory ${SCRIPT_DIR}/iterfact.wasm --invoke iterFact 10
wasmtime ${SCRIPT_DIR}/iterfact.wasm --invoke iterFact 10
