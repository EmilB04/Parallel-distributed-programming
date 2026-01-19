package emilbe;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Extending Thread Class - Creating 20 Threads ===");
        int n = 20;
        
        for (int i = 0; i < n; i++) {
            Task t = new Task();
            t.start();
        }
        
        System.out.println("\nAll 20 threads have been started.\n");
    }
}
