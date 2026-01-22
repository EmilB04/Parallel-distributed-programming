package demoExRunnable;

import java.util.concurrent.TimeUnit;
public class Task implements Runnable {

    private final String name;

    public Task(String name){
        this.name=name;
    }

    public void run() {
        Long duration=(long)(Math.random()*10);
        System.out.printf("%s: Executing %s during %d seconds\n", Thread.currentThread().getName(), name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished\n",Thread.currentThread().getName(),name);
    }

}