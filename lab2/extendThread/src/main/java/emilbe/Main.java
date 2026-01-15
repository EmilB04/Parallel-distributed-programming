package emilbe;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int i = 0;
        for (i = 0; i < n; i++) {
            Task t = new Task();
            t.start();
        }

        for (i = 0; i < n; i++) {}
    }
}
