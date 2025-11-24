package com.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophersProblem {
    public static void main(String[] args) {
        final Semaphore[] forks = new Semaphore[] {
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1) };
        ExecutorService service = Executors.newFixedThreadPool(4);
        Philosopher[] greats = new Philosopher[4];
        for (int i = 0; i < 4; i++) {
            greats[i] = new Philosopher(forks, i);
            service.execute(greats[i]);
        }
    }
}

class Philosopher implements Runnable {
    private Semaphore[] forks;
    private int place;

    public Philosopher(Semaphore[] forks, int place) {
        this.forks = forks;
        this.place = place;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Thinking
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100));

                forks[place].acquire();
                forks[(place + 1) % 5].acquire();
                System.out.println("Philosopher at seat " + place + " is eating");
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100));

                forks[place].release();
                forks[(place + 1) % 5].release();
                System.out.println("Philosopher at seat " + place + " is eating Finished!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
