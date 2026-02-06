package serial;

public class MatrixMatrixMulSerial {

    public int[][] multiply(int[][] matrix1, int[][] matrix2)
    {
        System.out.println("Serial Running ....");

        int N = matrix1.length;
        System.out.println("N = " + N);
        int M = matrix2.length;
        System.out.println("M = " + M);
        int P = matrix2[0].length;
        System.out.println("Result matrix = " + N + "x" + P);

        int[][] result = new int[N][P];
        //TODO: Serial Implementation of matrix-matrix multiplication

        return result;
    }
}
