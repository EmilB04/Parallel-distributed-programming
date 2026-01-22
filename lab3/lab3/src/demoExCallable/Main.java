package demoExCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Create the executor
        ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // List to store the Future objects that control the execution of  the task and
        // are used to obtain the results
        List<Future<Long>> resultList=new ArrayList<>();

        // create 100 tasks
        System.out.println("Main: Starting.");
        for (int i=0; i<10; i++){
            Task task=new Task("Task_"+i);
            Future<Long> result = executor.submit(task);
            resultList.add(result);
        }

        // Wait for the finalization of the ten tasks
        do {
            System.out.println("Main: Number of completed tasks is " + executor.getCompletedTaskCount());
            for (int i=0; i<resultList.size(); i++) {
                Future<Long> result=resultList.get(i);
                try {
                    System.out.println("Returned value is " + result.get());
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Main: Task " + i + " isDone " + result.isDone());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());

        // Write the results
        System.out.println("Main: Results");
        for (int i=0; i<resultList.size(); i++) {
            Future<Long> result=resultList.get(i);
            Long number=null;
            try {
                number=result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Core: " +i+ " Task " + number);
        }
        // Shutdown the executor
        System.out.println("Main: Shut down the Executor");
        executor.shutdown();
        System.out.println("Main: End");
    }
}