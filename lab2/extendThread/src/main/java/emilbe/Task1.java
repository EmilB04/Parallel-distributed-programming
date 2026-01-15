package emilbe;

public class Task1 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Task1 started: " + Thread.currentThread().getName());
            Thread.sleep(300); // Simulate some work with sleep
            System.out.println("Task1 finished: " + Thread.currentThread().getName());
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
