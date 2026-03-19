# MPI Java Lab Setup (MPJ Express)

This project uses the `mpi.*` package, which is provided by MPJ Express (not by the default Java/OpenMPI install on this machine).

## Quick start

Run these commands from this folder (`untitled`):

```bash
chmod +x scripts/*.sh
./scripts/setup-mpj.sh
./scripts/compile.sh
./scripts/run.sh 4 HelloWorld
```

## Example runs

```bash
./scripts/run.sh 2 Echo
./scripts/run.sh 4 MatrixMatrixMult 512
```

Notes:
- `Echo` requires exactly `2` processes.
- `MatrixMatrixMult` requires one argument `N` (matrix size `N x N`).

## What was failing before

`javac src/*.java` failed with `package mpi does not exist` because the MPI Java library was not on the classpath.

The compile script now uses:

```bash
javac -cp .tools/mpj-v0_44/lib/mpj.jar -d out src/*.java
```
