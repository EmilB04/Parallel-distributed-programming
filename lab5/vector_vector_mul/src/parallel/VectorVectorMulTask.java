package parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class VectorVectorMulTask extends RecursiveTask<Integer> {

    public static final int THRESHOlD = 10;
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
        // TODO: Your code for parallel task
        // check data size to see if the task can perform job or task should be further split up
        return 0;
    }
}
