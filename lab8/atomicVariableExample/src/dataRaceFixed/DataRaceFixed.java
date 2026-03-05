import java.util.concurrent.atomic.AtomicInteger;
class SharedCounter1 {
    static AtomicInteger count = new AtomicInteger(0);
}
class IncreaseThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            SharedCounter1.count.addAndGet(10);
        }
    }
}

class DecreaseThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            SharedCounter1.count.addAndGet(-10);
        }
    }
}

public class DataRaceFixed {
    public static void main(String[] args) {
        Thread t1 = new IncreaseThread1();
        Thread t2 = new DecreaseThread1();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + SharedCounter1.count);
    }
}