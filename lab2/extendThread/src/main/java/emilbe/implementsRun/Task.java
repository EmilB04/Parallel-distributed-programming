package emilbe.implementsRun;

public class Task implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Runnable Task started: " + Thread.currentThread().getName());
            Thread.sleep(400); // Simulate some work with sleep
            System.out.println("Runnable Task finished: " + Thread.currentThread().getName());
        } 
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
