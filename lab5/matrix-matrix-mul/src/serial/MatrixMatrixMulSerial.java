package serial;

public class MatrixMatrixMulSerial {

    public int[][] multiply(int[][] matrix1, int[][] matrix2)
    {
        System.out.println("Serial Running ....");

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
        System.out.println("N = " + N);
        int M = matrix2.length;
        System.out.println("M = " + M);
        int P = matrix2[0].length;
        System.out.println("Result matrix = " + N + "x" + P);

        int[][] result = new int[N][P];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                int a = matrix1[i][k];
                for (int j = 0; j < P; j++) {
                    result[i][j] += a * matrix2[k][j];
                }
            }
        }

        return result;
    }
}
