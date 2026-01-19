package emilbe.implementsRun;

import java.time.LocalDateTime;

public class Task implements Runnable {

    @Override
    public void run() {
        LocalDateTime creationTime = LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedCreationTime = creationTime.format(formatter);

        System.out.println("Hello! Thread Name: " + Thread.currentThread().getName()
                + ", Thread ID: " + Thread.currentThread().getId()
                + ", Creation Time: " + formattedCreationTime);

        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime terminationTime = LocalDateTime.now();
        String formattedTerminationTime = terminationTime.format(formatter);
        System.out.println("Thread " + Thread.currentThread().getName()
                + " terminating at: " + formattedTerminationTime);
    }
}
