import java.util.concurrent.TimeUnit;
public class DecreaseTask implements Runnable{
    private DataRace Counter;
    public DecreaseTask(DataRace singleC) {
        this.Counter = singleC;
    }

    public void run() {
        System.out.printf("Thread: %s is decreasing the counters%n", Thread.currentThread().getId());

        for(int i = 1; i <= 10; i++){
            Counter.decrement();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.printf("Thread: %s finished%n", Thread.currentThread().getId());
    }
}