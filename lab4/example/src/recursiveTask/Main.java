package recursiveTask;

// Main Class
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int end = 1000;

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task
        Task task = new Task(start, end);

        // Invoke the task and get the result
        int result = pool.invoke(task);

        // Print the result
        System.out.println("The sum of the first 1000 integers is: " + result);
    }
}
