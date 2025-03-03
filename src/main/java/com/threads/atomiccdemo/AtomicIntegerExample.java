package com.threads.atomiccdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The AtomicInteger class protects an underlying int value by providing methods
 * that perform atomic operations on the value.
 * It shall not be used as a replacement for an Integer class.
 */
public class AtomicIntegerExample {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static Integer intCount = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            increment();
        });

        Thread t2 = new Thread(() -> {
            increment();
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
        System.out.println(intCount);
    }

    private static void increment() {
        for (int i = 0; i < 10000; i++) {
            counter.incrementAndGet();
            intCount++;
        }
    }
}
