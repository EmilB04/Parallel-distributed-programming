public class Task extends RecursiveTask<Object><Integer> {

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
            // TODO: Add your code here to do the task directly
        } else {
            int middle = (last + first) / 2;
            // TODO: Add your code here to divide the task into two smaller tasks
            // TODO: Add your code here to invoke the two tasks and wait for the results
            return t1.join() + t2.join();
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
