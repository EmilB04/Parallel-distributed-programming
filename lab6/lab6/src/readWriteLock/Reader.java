package readWriteLock;
import java.util.Date;
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader (PricesInfo pricesInfo){
        this.pricesInfo=pricesInfo;
    }

    public void run() {
        for (int i=0; i<3; i++){
            System.out.printf("%s: %s: Reader: Price 1: %f\n",new Date(), Thread.currentThread().getName(),pricesInfo.getPrice1());
            System.out.printf("%s: %s: Reader: Price 2: %f\n",new Date(), Thread.currentThread().getName(),pricesInfo.getPrice2());
        }
    }

}

