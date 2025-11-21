package com.threads.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CountDownLatchDemo implements Runnable {
    private CountDownLatch latch;
    private int id;

    public CountDownLatchDemo(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        doMyWork();
        latch.countDown();
    }

    private void doMyWork() {
        try {
            System.out.println("Thread id: " + id + " start workign !!");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 5; i++) {
                service.execute(new CountDownLatchDemo(latch, i));
            }
            latch.await();
        } catch (InterruptedException ex) {
        }
        System.out.println("All task have been compleated!");
        service.shutdown();
    }
}
