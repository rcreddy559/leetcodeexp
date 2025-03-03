package com.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new SomeService("Thread - " + i, i, countDownLatch)).start();
        }
        
        try {
            System.out.println("Main thread waiting for service ot initialize.....");
            countDownLatch.await();
            System.out.println("All service started, Main applicaiton starting ....");
        } catch (InterruptedException e) {
            e.printStackTrace();
            ;
        }
    }

}

class SomeService implements Runnable {
    private String name;
    private final int i;
    private CountDownLatch countDownLatch;

    SomeService(String name, int i, CountDownLatch countDownLatch) {
        this.name = name;
        this.i = i;
        this.countDownLatch = countDownLatch;
    }
        
    
    @Override
    public void run() {
        try {
            System.out.println(name + " Count down Latch START:" + i);
            Thread.sleep(2000);
            System.out.println(name + " Service started .... ");
            countDownLatch.countDown();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}
