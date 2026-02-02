import java.util.concurrent.RecursiveTask;
public class Task extends RecursiveTask<Integer> {

    int[] array;
    int threshold;
    int first;
    int last;

    public Task(int[] array, int first, int last, int threshold) {
        this.array = array;
        this.first = first;
        this.last = last;
        this.threshold = threshold;
    }

    protected Integer compute() {
        if (last - first < threshold) {
            return calculate();
        } else {
            int middle = (last + first) / 2;
            Task t1 = new Task(array, first, middle, threshold);
            Task t2 = new Task(array, middle, last, threshold);
            t1.fork();
            int right = t2.compute();
            int left = t1.join();
            return left + right;
        }
    }

    protected Integer calculate() {
        Integer count = 0;
        for (int i = first; i < last; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
