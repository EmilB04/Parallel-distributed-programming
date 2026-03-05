import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DeadlockLock {
    private final static Lock lock1 = new ReentrantLock();
    private final static Lock lock2 = new ReentrantLock();

    public static void main(String args[]) {
        Thread1 T1 = new Thread1();
        Thread2 T2 = new Thread2();
        T1.start();
        T2.start();
    }
    private static class Thread1 extends Thread {
        public void run() {
            lock1.lock();
            System.out.println("Thread 1: Holds lock1.");
            lock2.lock();
            System.out.println("Thread 1: Holds lock2.");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                System.out.println("Thread 1: Release lock2.");
                lock1.unlock();
                System.out.println("Thread 1: Release lock1.");
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            lock2.lock();
            System.out.println("Thread 2: Holds lock2.");
            lock1.lock();
            System.out.println("Thread 2: Holds lock1.");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                System.out.println("Thread 2: Released lock1.");
                lock2.unlock();
                System.out.println("Thread 2: Released lock2.");
            }
        }
    }
}
