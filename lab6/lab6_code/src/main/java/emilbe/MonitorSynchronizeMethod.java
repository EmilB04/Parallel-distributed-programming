package emilbe;

class Number {
    synchronized void printNumber(int n) {
        int temp = 1;
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n * i);
            temp = n * temp;
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Thread1 extends Thread {
    Number p;

    Thread1(Number p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.printNumber(2);
    }
}

class Thread2 extends Thread {
    Number p;

    Thread2(Number p) {
        this.p = p;
    }
    @Override
    public void run() {
        p.printNumber(10);
    }
}

public class MonitorSynchronizeMethod {
    public static void main(String args[]) {
        Number obj = new Number();// only one object
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}