package reentrantLock;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Work {

    public static void doTask() {

        long duration = ThreadLocalRandom.current().nextLong(10);
        System.out.printf("%s: Working %d seconds\n",Thread.currentThread().getName(),duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finished\n",Thread.currentThread().getName());
    }

}
