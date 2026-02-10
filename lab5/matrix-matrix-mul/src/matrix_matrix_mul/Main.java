package matrix_matrix_mul;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import parallel.MatrixMatrixMulParallel;
import serial.MatrixMatrixMulSerial;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int N = 10;
        int M = 10;
        int P = 10;
        int[][] matrix1 = generate2DArray(N, M);
        int[][] matrix2 = generate2DArray(M, P);

        MatrixMatrixMulSerial matrixMatrixMulSerial = new MatrixMatrixMulSerial();
        MatrixMatrixMulParallel matrixMatrixMulParallel = new MatrixMatrixMulParallel();

        // Because the matrix-matrix multiplication problem is heavy computation, it is
        // ok run only once ((RUNS = 1))
        // but if you can try with multiple RUNS

        // Serial version
        long serialStart = System.nanoTime();
        int[][] resultSerial = matrixMatrixMulSerial.multiply(matrix1, matrix2);
        long serialEnd = System.nanoTime();
        long serialTime = serialEnd - serialStart;

        // Parallel version
        long parallelStart = System.nanoTime();
        int[][] resultParallel = matrixMatrixMulParallel.multiply(matrix1, matrix2);
        long parallelEnd = System.nanoTime();
        long parallelTime = parallelEnd - parallelStart;

        // This method checks if your serial and parallel implementations produce the
        // same output.
        // If yes, our parallel implementation and serial implementation are correct.
        compareResults(resultSerial, resultParallel);
        System.out.println("Serial time: " + serialTime + " ns");
        System.out.println("Parallel time: " + parallelTime + " ns");
        
        // Speedup:
        if (parallelTime > 0) {
            double speedup = (double) serialTime / (double) parallelTime;
            System.out.println("Speedup is " + speedup);
        } else {
            System.out.println("Speedup is undefined (parallel time is 0 ns)");
        }
    }

    private static int[][] generate2DArray(int N, int M) {
        System.out.println("generate2DArray ....");
        Random random = new Random(20260204);

        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                a[i][j] = random.nextInt(10);

        return a;
    }

    private static void compareResults(int[][] arr1, int[][] arr2) {
        if (Arrays.deepEquals(arr1, arr2))
            System.out.println("The results are the same");
        else
            System.out.println("The results are NOT the same. Check your implementation");
    }
}
