package emilbe;

// Thread is a built-in Java class in java.lang package
public class Task extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread started: " + Thread.currentThread().getName());
            Thread.sleep(500); // Simulate some work with sleep
            System.out.println("Thread finished: " + Thread.currentThread().getName());
        } 
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
