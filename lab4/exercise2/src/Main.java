
import java.util.Random;

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
        int threshold = Integer.parseInt(args[0]);
        // threshold indicates the threshold based on which
        // ...you decide if a task is to be subdivided or not
        int paral_level = Integer.parseInt(args[1]);
        // paral_level indicates how many tasks can be run in parallel
        // TODO: Add your code here to get the number of processors
        // and store this number in the variable named num_of_proccessors
        long startTime = System.currentTimeMillis();
        Task mainTask = new Task(array, 0, SIZE, threshold);
        // TODO: Add your code here to create the ForkJoin pool
        // with the parallel level paral_level passed from users.
        Integer numberOfEvenNumber = pool.invoke(mainTask);
        long endTime = System.currentTimeMillis();
        System.out.println("Threshold: " + threshold + " - Parallel level: " +
                pool.getParallelism() + " - Number of processors: " + num_of_proccesors);
        System.out.println("The number of even numbers is " + numberOfEvenNumber);
        long time = (endTime - startTime);
        System.out.println("Running time is " + time + " ms");
    }
}