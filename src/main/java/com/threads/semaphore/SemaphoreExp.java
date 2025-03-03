package com.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExp {

    final private static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task(i)).start();
        }
    }

    static class Task implements Runnable {
        int i = 0;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Thread " + i + " acquired the semaphore");
                Thread.sleep(2000);
                System.out.println("Thread " + i + " released the semaphore");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
