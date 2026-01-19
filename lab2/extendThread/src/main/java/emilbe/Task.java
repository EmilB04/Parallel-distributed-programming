package emilbe;

import java.time.LocalDateTime;

// Thread is a built-in Java class in java.lang package
public class Task extends Thread {

    @Override
    public void run() {
        LocalDateTime creationTime = LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String isoCreationTime = creationTime.format(formatter);

        System.out.println("Hello! Thread Name: " + Thread.currentThread().getName()
                + ", Thread ID: " + Thread.currentThread().getId()
                + ", Creation Time: " + isoCreationTime);

        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime terminationTime = LocalDateTime.now();
        String isoTerminationTime = terminationTime.format(formatter);
        System.out.println("Thread " + Thread.currentThread().getName()
                + " terminating at: " + isoTerminationTime);
    }
}
