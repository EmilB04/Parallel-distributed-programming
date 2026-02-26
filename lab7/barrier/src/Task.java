import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    private CyclicBarrier barrier;
    public Task(CyclicBarrier barrier) {
        this.barrier=barrier;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+": Phase 1");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.printf("%s: Sleeping for a duration of 100 ms\n", Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": Phase 2");
    }
}
