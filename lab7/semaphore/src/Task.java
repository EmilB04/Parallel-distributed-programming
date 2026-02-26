import java.util.concurrent.Semaphore;
public class Task implements Runnable{
    private Semaphore semaphore;
    public Task(Semaphore semaphore) {
        this.semaphore=semaphore;
    }
    public void run() {
        try {
            semaphore.acquire();
            TaskController.Task();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}