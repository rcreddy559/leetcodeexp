package com.threads.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {
    BlockingQueue<Integer> queue;

    FirstWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            int count = 0;

            while (true) {
                Thread.sleep(1000);
                System.out.println("Adding new item to queue: " + count);
                queue.put(count++);
                if (queue.size() == 10)
                    System.out.println("Ques full waiting to take value by second worker!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondWorker implements Runnable {
    BlockingQueue<Integer> queue;

    SecondWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(2500);
                int count = queue.take();
                System.out.println("Taking item from queue: " + count);
                if (queue.size() == 0)
                    System.out.println("Queue empty waiting to put value by First worker!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        new Thread(new FirstWorker(queue)).start();
        new Thread(new SecondWorker(queue)).start();
    }
}
