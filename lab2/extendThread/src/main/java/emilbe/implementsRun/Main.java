package emilbe.implementsRun;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Implementing Runnable Interface - Creating 20 Threads ===");
        int n = 20;
        
        for (int i = 0; i < n; i++) {
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();
        }
        
        System.out.println("\nAll 20 threads have been started.\n");
    }
}
