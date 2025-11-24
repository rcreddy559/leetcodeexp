package com.threads.executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CyclicBarrierWorker implements Runnable {
    private CyclicBarrier barrier;
    private int id;

    CyclicBarrierWorker(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread id: " + id + " Preparing!");
        try {
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println("Thread id: " + id + " at barrier!");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Thread id: " + id + " continue after barrier!");
    }
}

public class CyclicBarrierExample {

    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("All threads have reached the barrier. Starting coordinated work!");
        });

        // Create thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        // Submit worker tasks
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(new CyclicBarrierWorker(barrier, i));
        }

        // Shutdown executor
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
