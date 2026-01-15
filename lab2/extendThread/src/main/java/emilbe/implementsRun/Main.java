package emilbe.implementsRun;

import emilbe.Task1;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int i;
        for (i = 0; i < n; i++) {
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();
        }
        for (i = 0; i < n; i++) {
            Task1 task1 = new Task1();
            task1.start();
        }
    }
}
