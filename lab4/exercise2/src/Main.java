
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static final int SIZE = 10_000_000;
    static int[] array = arrayGen();

    static int[] arrayGen() {
        int[] arr = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public static void main(String[] args) {
        // Added command line argument handling
        if (args.length < 2) {
        System.err.println("Usage: java Main <threshold> <parallel_level>");
        System.exit(2);
        }

        int threshold;
        int paral_level;

        try {
            threshold = Integer.parseInt(args[0]);
            paral_level = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Usage: java Main <threshold> <parallel_level>  (both integers)");
            System.exit(2);
            return;
        }
        // threshold indicates the threshold based on which
        // ...you decide if a task is to be subdivided or not
        // paral_level indicates how many tasks can be run in parallel
        int num_of_proccesors = Runtime.getRuntime().availableProcessors();

        long startTime = System.currentTimeMillis();
        Task mainTask = new Task(array, 0, SIZE, threshold);
        ForkJoinPool pool = new ForkJoinPool(paral_level);

        Integer numberOfEvenNumber = pool.invoke(mainTask);
        long endTime = System.currentTimeMillis();
        System.out.println("Threshold: " + threshold + " - Parallel level: " +
                pool.getParallelism() + " - Number of processors: " + num_of_proccesors);
        System.out.println("The number of even numbers is " + numberOfEvenNumber);
        long time = (endTime - startTime);
        System.out.println("Running time is " + time + " ms");
    }
}