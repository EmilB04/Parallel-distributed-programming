package parallel;

import java.util.concurrent.ForkJoinPool;

public class VectorVectorMulParallel {
    public int multiParallel(int[] vector1, int[] vector2){
        System.out.println("Parallel program is running ...");
        int N = vector1.length;
        // TODO: Your code to generate original task
        VectorVectorMulTask task = new VectorVectorMulTask(vector1, vector2, 0, N-1);
        // TODO: Your code to create a ForkJoin pool and send the task to the pool
        return 0;
    }
}
