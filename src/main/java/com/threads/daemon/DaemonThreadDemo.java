package com.threads.daemon;

class WorkerThread implements Runnable {

    private final int threadNumber;

    public WorkerThread(int i) {
        this.threadNumber = i;
    }

    @Override
    public void run() {
        try {
            System.out.printf("\nName: %s, Thread priority: %d\n", Thread.currentThread().getName(),
                    Thread.currentThread().getPriority());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker Thread is running: " + threadNumber);
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

        Thread t1 = new Thread(new WorkerThread(1), "Worker Thread-1");
        Thread t2 = new Thread(new WorkerThread(2), "Worker Thread-2");
        Thread t3 = new Thread(new DaemonThread(), "Daemon Thread");
        t3.setDaemon(true);

        System.out.println("Starting Thread");
        System.out.println("t1 is: " + t1.getName());
        System.out.println("t2 is: " + t2.getName());

        t1.start();
        t2.start();
        t3.start();
    }
}
