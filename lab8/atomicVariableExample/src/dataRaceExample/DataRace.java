class SharedCounter {
    static int count = 0; // Shared resource
}

class IncreaseThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            int temp = SharedCounter.count + 10;
            SharedCounter.count = temp;
        }
    }
}

class DecreaseThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            int temp = SharedCounter.count - 10;
            SharedCounter.count = temp;
        }
    }
}

public class DataRace {
    public static void main(String[] args) {
        Thread t1 = new IncreaseThread();
        Thread t2 = new DecreaseThread();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + SharedCounter.count);
    }
}