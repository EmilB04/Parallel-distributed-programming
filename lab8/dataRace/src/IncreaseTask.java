import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class IncreaseTask implements Runnable {
    private DataRace counter;
    public IncreaseTask(DataRace singleC) {
        this.counter = singleC;
    }
    public void run() {
        System.out.printf("Thread: %s is increasing the counters%n", Thread.currentThread().getId());
        for(int i = 1; i <= 10; i++){
            counter.increment();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Thread: %s finished%n", Thread.currentThread().getId());
    }
}
