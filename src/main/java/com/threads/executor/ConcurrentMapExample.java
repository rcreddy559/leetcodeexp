package com.threads.executor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
//        ConcurrentHashMap<String, Integer> cMap = new ConcurrentHashMap<>();
//        new Thread(new FirstWorker(cMap)).start();
//        new Thread(new SecondWorker(cMap)).start();
    }
}

class FirstWorker2 implements Runnable {
    private ConcurrentMap<String, Integer> cMap;

    public FirstWorker2(ConcurrentMap<String, Integer> map) {
        this.cMap = map;
    }

    @Override
    public void run() {
        try {
            cMap.put("A", 2000);
            Thread.sleep(1000);
            cMap.put("X", 900);
            Thread.sleep(1000);
            cMap.put("F", 600);
            Thread.sleep(400);
            cMap.put("Z", 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondWorker3 implements Runnable {
    private ConcurrentMap<String, Integer> cMap;

    public SecondWorker3(ConcurrentMap<String, Integer> map) {
        this.cMap = map;
    }

    @Override
    public void run() {
        try {
            System.out.println(cMap.remove("A"));
            Thread.sleep(5000);
            System.out.println(cMap.remove("X"));
            Thread.sleep(1000);
            System.out.println(cMap.remove("F"));
            Thread.sleep(1000);
            System.out.println(cMap.remove("Z"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}