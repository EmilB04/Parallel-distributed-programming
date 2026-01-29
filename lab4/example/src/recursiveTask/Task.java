package recursiveTask;

import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10; // Threshold for splitting tasks
    private int start;
    private int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= THRESHOLD) {
            // Compute sum directly if within the threshold
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // Split task into two subtasks
            int mid = (start + end) / 2;
            Task leftTask = new Task(start, mid);
            Task rightTask = new Task(mid + 1, end);

            // Fork subtasks
            leftTask.fork();
            rightTask.fork();

            // Join results
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine results
            return leftResult + rightResult;
        }
    }
}
