
import java.util.concurrent.Semaphore;

public class Exercise2 {

    private final Semaphore semaphoreA = new Semaphore(0); // TaskA waits initially
    private final Semaphore semaphoreB = new Semaphore(1); // TaskB can start first

    public void doTaskA() {
        for (int i = 0; i < 3; i++) {
            try {
                // Wait for TaskB to signal
                semaphoreA.acquire();
                System.out.print("Debugging begins in 3... 2... 1...\n");
                // Signal TaskB to continue
                semaphoreB.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doTaskB() {
        for (int i = 0; i < 3; i++) {
            try {
                // Wait for our turn (initially available)
                semaphoreB.acquire();
                System.out.print("Welcome to the world of programming. ");
                // Signal TaskA to proceed
                semaphoreA.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            controller.doTaskA();
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
            controller.doTaskB();
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