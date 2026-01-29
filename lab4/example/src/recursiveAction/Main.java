package recursiveAction;

import java.util.concurrent.ForkJoinPool;
// This example computes the sumation of the first 1000 integers using RecusiveAction
public class Main {
    public static void main(String[] args) {
        int start = 1;
        int end = 1000;

        // Result array to hold the sum
        int[] result = new int[1];

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task
        Task task = new Task(start, end, result);

        // Invoke the task
        pool.invoke(task);

        // Print the result
        System.out.println("The sum of the first 1000 integers is: " + result[0]);
    }
}
