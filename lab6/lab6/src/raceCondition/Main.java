package raceCondition;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        DataRace counter = new DataRace();
        ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //Create 10 increasing tasks
        for (int i=0; i<10; i++) {
            IncreaseTask thread = new IncreaseTask(counter);
            executor.execute(thread);
        }
        //Create 10 decreasing tasks
        for (int i=0; i<10; i++) {
            DecreaseTask thread = new DecreaseTask(counter);
            executor.execute(thread);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }

}

