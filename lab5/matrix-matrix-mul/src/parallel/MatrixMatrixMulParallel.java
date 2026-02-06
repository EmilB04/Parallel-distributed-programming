package parallel;

import java.util.concurrent.ForkJoinPool;


public class MatrixMatrixMulParallel {

    public int[][] multiply(int[][] matrix1, int[][] matrix2) {

        System.out.println("Parallel Running ....");

        int N = matrix1.length;
        int P = matrix2[0].length;
        int[][] result = new int[N][P];

        MatrixMatrixMulTask mytask = new MatrixMatrixMulTask(matrix1, matrix2, 0, N, result);
       // TODO: your code to create a ForkJoin pool

      // TODO: your code to create and send mytask to the pool

        return result;
    }
}
