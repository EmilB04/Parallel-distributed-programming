import java.util.concurrent.locks.ReentrantLock;

public class DataRace {
    private int count = 0;
    public DataRace() {
        count = 0;
    }
    public void increment() {
        count++;
    }
    public void decrement() {
        count--;
    }
    public  int getCounter() {
        return count;
    }

    public String toString() {
        return "FinalValueCount [count=" + count + "]";
    }
}

