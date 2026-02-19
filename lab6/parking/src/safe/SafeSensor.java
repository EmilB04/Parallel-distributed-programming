package safe;
import java.util.concurrent.TimeUnit;

public class SafeSensor implements Runnable {
    private SafeParkingStats stats;
    public SafeSensor(SafeParkingStats stats) {
        this.stats = stats;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            stats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoGoOut();
            stats.carGoOut();
        }
    }

}
