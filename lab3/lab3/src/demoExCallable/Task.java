package demoExCallable;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<Long> {

    private final String name;
    public Task(String name){
        this.name=name;
    }
    public Long call() throws Exception {
        System.out.printf("%s: Task %s: Executed on: %s\n",Thread.currentThread().getName(),name,new Date());
        Long duration=(long)(Math.random()*10);
        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),new Date(),name);

        return duration;
    }
}
