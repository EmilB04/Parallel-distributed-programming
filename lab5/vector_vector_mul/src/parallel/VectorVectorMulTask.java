package parallel;

import java.util.concurrent.RecursiveTask;

public class VectorVectorMulTask extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 10;
    private int[] vector1;
    private int[] vector2;
    private int start;
    private int end;
    public VectorVectorMulTask(int[] vector1, int[] vector2, int start, int end){
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        // end is treated as inclusive.
        if (end < start) {
            return 0;
        }

        int size = end - start + 1;
        if (size <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += vector1[i] * vector2[i];
            }
            return sum;
        }

        int mid = start + (end - start) / 2;
        VectorVectorMulTask left = new VectorVectorMulTask(vector1, vector2, start, mid);
        VectorVectorMulTask right = new VectorVectorMulTask(vector1, vector2, mid + 1, end);

        left.fork();
        int rightResult = right.compute();
        int leftResult = left.join();
        return leftResult + rightResult;
    }
}
