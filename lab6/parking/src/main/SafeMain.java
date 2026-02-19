package main;
import safe.SafeParkingCash;
import safe.SafeParkingStats;
import safe.SafeSensor;
public class SafeMain {

    public static void main(String[] args) {
        SafeParkingCash cash = new SafeParkingCash();
        SafeParkingStats stats = new SafeParkingStats(cash);

        System.out.println("Parking Simulator");
        int numberSensors=2 * Runtime.getRuntime().availableProcessors();
        System.out.println("numberSensors=" + numberSensors);
        Thread threads[]=new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            SafeSensor sensor=new SafeSensor(stats);
            Thread thread=new Thread(sensor);
            thread.start();
            threads[i]=thread;
        }

        for (int i=0; i< numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", stats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n", stats.getNumberMotorcycles());
        cash.close();
    }
}


