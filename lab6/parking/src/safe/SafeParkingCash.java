package safe;
public class SafeParkingCash {
    private static final int cost=1;
    private long cash;
    public SafeParkingCash() {
        cash=0;
    }
    public synchronized void vehiclePay() {
        cash+=cost;
    }
    public void close() {
        System.out.printf("Closing accounting%n");
        long totalAmount;
        synchronized (this) {
            totalAmount=cash;
            cash=0;
        }
        System.out.printf("The total amount is : %d",totalAmount);
    }
}
