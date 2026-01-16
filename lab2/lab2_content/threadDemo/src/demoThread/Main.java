package demoThread;

public class Main {
    public static void main(String[] args){
        int n = 10; // number of threads
        for (int i = 0; i < n; i ++){
            Task obj = new Task();
            obj.start();
        }
    }
}

