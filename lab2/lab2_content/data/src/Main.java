import java.util.Date;
public class Main {
    public static void main(String[] args) {

        // Creates and starts a DataSourceLoader runnable object
        DataSourcesLoader thread1 = new DataSourcesLoader();

        // Creates and starts a NetworkConnectionsLoader runnable object
        NetworkConnectionsLoader thread2 = new NetworkConnectionsLoader();
       
        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for the finalization of the two threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Waits a message
        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
}