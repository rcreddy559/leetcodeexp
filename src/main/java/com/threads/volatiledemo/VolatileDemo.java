package com.threads.volatiledemo;

class Worker implements Runnable {

    private volatile boolean terminated;

    @Override
    public void run() {
        while (!terminated) {
            System.out.println("Worker class is running....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public boolean getTerminated() {
        return terminated;
    }

}

public class VolatileDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Terminated!!");
    }
}
