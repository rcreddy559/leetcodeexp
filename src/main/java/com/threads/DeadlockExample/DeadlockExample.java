package com.threads.DeadlockExample;

public class DeadlockExample {

    public static void main(String[] args) {

        String obj1 = "abc";
        String obj2 = "xyz";

        Thread t1 = new Thread("Thread-1") {
            public void run() {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " has acquired lock on obj1");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " waiting for lock on obj2");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + " has acquired lock on obj2");
                        System.out.println(Thread.currentThread().getName() + " task complete");
                    }
                }
            }
        };

        Thread t2 = new Thread("Thread-2") {
            public void run() {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + " has acquired lock on obj2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " waiting for lock on obj1");
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + " has acquired lock on obj1");
                        System.out.println(Thread.currentThread().getName() + " task complete");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
