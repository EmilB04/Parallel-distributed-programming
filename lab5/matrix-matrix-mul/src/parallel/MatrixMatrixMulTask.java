package parallel;

import java.util.concurrent.RecursiveAction;

public class MatrixMatrixMulTask extends RecursiveAction {

    private static final long serialVersionUID = 935729182687362668L;

    private int[][] matrix1;
    private int[][] matrix2;
    private int startRow, endRow;
    private int[][] result;
    private int threshold = 1_000; // You can modify this variable

    public MatrixMatrixMulTask(int[][] matrix1, int[][] matrix2, int startRow, int endRow, int[][] result) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startRow = startRow;
        this.endRow = endRow;
        this.result = result;
    }

    protected void compute() {
        // TODO: Your code for parallel task
        // check data size to see if the task can perform job or task should be further split up

    }
}

