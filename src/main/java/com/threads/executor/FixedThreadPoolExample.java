package com.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit multiple tasks to demonstrate thread pool behavior
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " executed by " + threadName);
                try {
                    // Simulate some work
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the executor service
        executorService.shutdown();

        try {
            // Wait for tasks to complete
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
