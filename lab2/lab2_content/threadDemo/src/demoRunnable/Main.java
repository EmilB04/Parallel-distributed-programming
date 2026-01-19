package demoRunnable;
public class Main {
    public static void main(String[] args){
        int n = 2000; // number of threads
        int i;
        for (i = 1; i < n; i ++){
            //           Thread obj = new Thread(new Task());
            Task obj = new Task();
            Thread t = new Thread(obj);
            t.start();
        }
    }
}

