package parallel;

import java.util.concurrent.ForkJoinPool;

public class VectorVectorMulParallel {
    public int multiParallel(int[] vector1, int[] vector2){
        System.out.println("Parallel program is running ...");
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("Input vectors must not be null");
        }
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Input vectors must have the same length");
        }
        if (vector1.length == 0) {
            return 0;
        }

        int n = vector1.length;

        // generate original task (end index is inclusive)
        VectorVectorMulTask task = new VectorVectorMulTask(vector1, vector2, 0, n - 1);

        // create a ForkJoin pool and send the task to the pool
        ForkJoinPool pool = ForkJoinPool.commonPool();
        return pool.invoke(task);
    }
}