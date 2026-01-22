package demoExRunnable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create the executor
        ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // create 100 task
        System.out.println("Main: Start");
        for (int i=0; i<100; i++){
            Task task=new Task("Task_"+i);
            executor.execute(task);
        }

        // Shutdown the executor
        System.out.println("Main: Shut down the Executor");
        executor.shutdown();
        System.out.println("Main: End");
    }
}