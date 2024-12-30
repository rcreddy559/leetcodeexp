package com.threads.daemon;

class WorkerThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker Thread is running");
    }
}

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread is running");
        }
    }
}

public class DaemonThreadDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(new WorkerThread(), "Worker Thread");
        Thread t2 = new Thread(new DaemonThread(), "Daemon Thread");
        t2.setDaemon(true);

        System.out.println("Starting Thread");
        System.out.println("t1 is: " + t1.getName());
        System.out.println("t2 is: " + t2.getName());

        t1.start();
        t2.start();
    }
}
