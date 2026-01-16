import java.util.Date;
import java.util.concurrent.TimeUnit;
public class DataSourcesLoader extends Thread {

    public void run() {

        System.out.printf("Begining data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}
