import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader extends Thread {

    public void run() {
        System.out.printf("Begining network connections loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network connections loading has finished: %s\n",new Date());
    }
}