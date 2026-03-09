

public class VolatileEx extends Thread {

    // Shared variable that controls the thread's loop
 //   private volatile boolean flag = true;
    private boolean flag = true;

    @Override
    public void run() {
        System.out.println("Thread started...");
        while (flag) {
            System.out.println("Hello World...");
        }

        System.out.println("Thread stopped.");
    }

    // Method to stop the thread by changing the volatile variable
    public void stopRunning() {
        flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            VolatileEx thread = new VolatileEx();
            thread.start();
            thread.stopRunning();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
