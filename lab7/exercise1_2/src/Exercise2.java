
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise2 {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int turn = 2; // 1 for TaskA, 2 for TaskB (initial state)

    public void doTaskA() {
        lock.lock();
        try {
            // Wait until turn is 1 (TaskB has finished)
            while (turn != 1) {
                condition.await();
            }
            System.out.print("Debugging begins in 3... 2... 1...\n");
            // Signal that TaskA is done
            turn = 2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doTaskB() {
        lock.lock();
        try {
            // Wait until turn is 2 (initial state)
            while (turn != 2) {
                condition.await();
            }
            System.out.print("Welcome to the world of programming. ");
            // Set turn to 1 to allow TaskA to proceed
            turn = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static class TaskA implements Runnable {
        private final Exercise2 controller;

        public TaskA(Exercise2 controller) {
            this.controller = controller;
        }

        @Override
        public void run() {
            // DONE: Your code to implement TaskA
            for (int i = 0; i < 3; i++) {
                controller.doTaskA();
            }
        }
    }

    static class TaskB implements Runnable {
        private final Exercise2 controller;

        public TaskB(Exercise2 controller) {
            this.controller = controller;
        }

        @Override
        public void run() {
            // DONE: Your code to implement TaskB
            for (int i = 0; i < 3; i++) {
                controller.doTaskB();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Exercise2 controller = new Exercise2();
            // DONE: your code to create thread1 and thread2
            Thread thread1 = new Thread(new TaskA(controller));
            Thread thread2 = new Thread(new TaskB(controller));
            // DONE: your code to start and join newly created threads
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            // DONE: your code to print the message:
            System.out.print("May your code compile on the first try (eventually).");
        }
    }
}