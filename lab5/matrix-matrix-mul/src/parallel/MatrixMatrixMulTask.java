package parallel;

import java.util.concurrent.RecursiveAction;

public class MatrixMatrixMulTask extends RecursiveAction {

    private static final long serialVersionUID = 935729182687362668L;

    private int[][] matrix1;
    private int[][] matrix2;
    private int startRow, endRow;
    private int[][] result;
    // Cutoff in number of rows for sequential work (tune as needed)
    private int threshold = 32;

    public MatrixMatrixMulTask(int[][] matrix1, int[][] matrix2, int startRow, int endRow, int[][] result) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startRow = startRow;
        this.endRow = endRow;
        this.result = result;
    }

    @Override
    protected void compute() {
        int rows = endRow - startRow;
        if (rows <= 0) {
            return;
        }

        if (rows <= threshold) {
            int m = matrix2.length;
            int p = matrix2[0].length;

            for (int i = startRow; i < endRow; i++) {
                for (int k = 0; k < m; k++) {
                    int a = matrix1[i][k];
                    for (int j = 0; j < p; j++) {
                        result[i][j] += a * matrix2[k][j];
                    }
                }
            }
            return;
        }

        int mid = startRow + rows / 2;
        MatrixMatrixMulTask left = new MatrixMatrixMulTask(matrix1, matrix2, startRow, mid, result);
        MatrixMatrixMulTask right = new MatrixMatrixMulTask(matrix1, matrix2, mid, endRow, result);
        invokeAll(left, right);

    }
}

