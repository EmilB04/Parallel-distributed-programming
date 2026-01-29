package recursiveAction;

import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
    private static final int THRESHOLD = 10; // Threshold for splitting tasks
    private int start;
    private int end;
    private int[] result;

    public Task(int start, int end, int[] result) {
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    protected void compute() {
        if ((end - start) <= THRESHOLD) {
            // Compute sum directly if within the threshold
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            result[0] += sum;
        } else {
            // Split task into two subtasks
            int mid = (start + end) / 2;
            int[] leftResult = new int[1];
            int[] rightResult = new int[1];

            Task leftTask = new Task(start, mid, leftResult);
            Task rightTask = new Task(mid + 1, end, rightResult);

            // Fork subtasks
            leftTask.fork();
            rightTask.fork();

            // Wait for subtasks to complete
            leftTask.join();
            rightTask.join();

            // Combine results
            result[0] += leftResult[0] + rightResult[0];
        }
    }
}

