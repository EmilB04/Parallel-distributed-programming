import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class App  {
    public static void main(String[] args) throws Exception {
        // Create the executor
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
                .newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        // List to store the Future objects that control the execution of the task and
        // are used to obtain the results
        List<Future<Long>> resultList = new ArrayList<>();
        

        // Create 100 tasks: task 1, task 2, ..., task 100
        System.out.println("Main: Starting.");
        for (int i = 1; i <= 100; i++){
            Task task = new Task(i);
            Future<Long> result = executor.submit(task);
            resultList.add(result);
        }
        
        // Wait for all tasks to complete
        for (Future<Long> future : resultList) {
            future.get();
        }
        
        // Shutdown the executor
        executor.shutdown();
        System.out.println("Main: All tasks completed.");
    }
}
