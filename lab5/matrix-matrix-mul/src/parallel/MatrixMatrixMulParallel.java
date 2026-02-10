package parallel;

import java.util.concurrent.ForkJoinPool;

public class MatrixMatrixMulParallel {

    public int[][] multiply(int[][] matrix1, int[][] matrix2) {

        System.out.println("Parallel Running ....");

        if (matrix1 == null || matrix2 == null) {
            throw new IllegalArgumentException("Input matrices must not be null");
        }
        if (matrix1.length == 0 || matrix2.length == 0) {
            return new int[0][0];
        }
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException(
                    "Incompatible dimensions: matrix1 is " + matrix1.length + "x" + matrix1[0].length +
                            ", matrix2 is " + matrix2.length + "x" + matrix2[0].length);
        }

        int N = matrix1.length;
        int P = matrix2[0].length;
        int[][] result = new int[N][P];

        MatrixMatrixMulTask mytask = new MatrixMatrixMulTask(matrix1, matrix2, 0, N, result);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(mytask);

        return result;
    }
}
