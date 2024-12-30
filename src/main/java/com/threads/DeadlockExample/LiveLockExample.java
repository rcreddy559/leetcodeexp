package com.threads.DeadlockExample;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        LiveLockExample liveLock = new LiveLockExample();

        new Thread(liveLock::worker1, "Worker -1 ").start();
        new Thread(liveLock::worker2, "Worker -2 ").start();

    }

    private void worker1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MICROSECONDS);
                System.out.println("Worker 1 qcqurieds the lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker 1 is trieing to get lock2");

            if (lock2.tryLock()) {
                System.out.println("Worker1 acquries the lock2");
                lock2.unlock();
            } else {
                System.out.println("worker1 can not acqurie lock2");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    private void worker2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MICROSECONDS);
                System.out.println("Worker 1 qcqurieds the lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker 1 is trieing to get lock2");

            if (lock1.tryLock()) {
                System.out.println("Worker1 acquries the lock2");
                lock1.unlock();
            } else {
                System.out.println("worker1 can not acqurie lock2");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
