package demoRunnable;

public class Task implements Runnable {
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running");
            Thread.sleep(500);
            System.out.print("Thread " + Thread.currentThread().getId() + " has finished\n");

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}