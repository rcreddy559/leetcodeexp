package com.threads.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        // Create a ScheduledThreadPoolExecutor with 2 core threads
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Task 1: Run once after a 5-second delay
        Runnable delayedTask = () -> {
            System.out.println("Delayed task executed after 5 seconds");
        };
        scheduler.schedule(delayedTask, 5, TimeUnit.SECONDS);

        // Task 2: Run periodically every 3 seconds, with initial 2-second delay
        Runnable periodicTask = () -> {
            System.out.println("Periodic task running at " + System.currentTimeMillis());
        };
        ScheduledFuture<?> periodicFuture = scheduler.scheduleAtFixedRate(
                periodicTask, 2, 3, TimeUnit.SECONDS);

        // Optional: Stop periodic task after 10 seconds
        try {
            Thread.sleep(10000);
            periodicFuture.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        scheduler.shutdown();
    }
}
