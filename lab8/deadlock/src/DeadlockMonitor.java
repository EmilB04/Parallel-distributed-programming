import java.util.concurrent.TimeUnit;
public class DeadlockMonitor {
    public static final Object resource1 = new Object();
    public static final Object resource2 = new Object();

    public static void main(String args[]) {
        Thread1 T1 = new Thread1();
        Thread2 T2 = new Thread2();
        T1.start();
        T2.start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println("Thread 1: Holds resource R1...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waits for resource R2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holds resource R1 and R2...");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println("Thread 2: Holds resource R2...");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waits for resource R1...");
                synchronized (resource2) {
                    System.out.println("Thread 2: Holds resource R1 and R2...");
                }
            }
        }
    }
}