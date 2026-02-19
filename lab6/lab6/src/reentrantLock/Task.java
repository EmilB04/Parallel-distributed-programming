package reentrantLock;
import java.util.concurrent.locks.ReentrantLock;
public class Task implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {

        lock.lock();
        try {
            System.out.println( name + ": Running the task");
            Work.doTask();
            System.out.println( name + ": The execution has finished");
        } finally {
            lock.unlock();
        }
    }

}