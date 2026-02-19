package raceCondition;

import java.util.concurrent.locks.ReentrantLock;

public class DataRace {
    private int count = 0;

    public DataRace() {
        count = 0;
    }
    private static ReentrantLock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }
    public  int getCounter() {
        return count;
    }

    public String toString() {
        return "FinalValueCount [count=" + count + "]";
    }

}
