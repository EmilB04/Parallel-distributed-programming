
import java.util.concurrent.atomic.AtomicInteger;

public class DataRace {
    private final AtomicInteger count = new AtomicInteger(0);

    public DataRace() {
        count.set(0);
    }

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCounter() {
        return count.get();
    }

    @Override
    public String toString() {
        return "FinalValueCount [count=" + count.get() + "]";
    }
}

