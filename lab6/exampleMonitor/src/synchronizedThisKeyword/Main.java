package synchronizedThisKeyword;
class Wallet {
    private int balance = 1000;
    public void pay(String user, int amount) {
        // Some work outside the synchronized block
        System.out.println(user + " wants to pay " + amount);
        int fee = 5;                 // local variable, thread‑safe
        int total = amount + fee;    // more local variables

        // Only this part is synchronized
        int newBalance;
        synchronized (this) {
            if (balance >= total) {
                balance -= total;         // shared state update
                newBalance = balance;     // capture correct value
            } else {
                System.out.println("Not enough money for " + user);
                return;
            }
        }
        // More work outside the synchronized block
        System.out.println(user + " paid " + amount +
                " (fee " + fee + "), new balance = " + newBalance);
    }
}
class MyTask extends Thread {
    private final Wallet wallet;

    public MyTask(Wallet wallet, String name) {
        super(name);
        this.wallet = wallet;
    }

    @Override
    public void run() {
        // Each thread calls pay() three times
        for (int i = 0; i < 3; i++) {
            wallet.pay(Thread.currentThread().getName(), 100);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Wallet sharedWallet = new Wallet();     // ONE shared object

        MyTask t1 = new MyTask(sharedWallet, "T1");
        MyTask t2 = new MyTask(sharedWallet, "T2");

        t1.start();
        t2.start();
    }
}
