import java.util.concurrent.locks.Lock;


public class Task2 implements Runnable {

    private final Lock lock;

    public Task2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Operations.processData();
        } finally {
            lock.unlock();
        }

        Operations.readData();

        lock.lock();
        try {
            Operations.writeData();
        } finally {
            lock.unlock();

        }
    }
}