package com.threads.ReentrantLockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Procuder method...");

        condition.await();
        System.out.println("Again the procer method...");
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        System.out.println("consumer method...");

        condition.await();
        System.out.println("Again the procer method...");
    }

}

public class ProducerConaumwneReentrenatLock {

    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
