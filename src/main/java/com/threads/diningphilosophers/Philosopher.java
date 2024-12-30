package com.threads.diningphilosophers;

import java.util.Random;

public class Philosopher implements Runnable {
    private int id;
    private volatile boolean full;
    private Chopstick lefetChopStick;
    private Chopstick rightChopStick;
    private Random random;
    private int eatingCount;

    public Philosopher(int id, Chopstick lefetChopStick, Chopstick rightChopStick) {
        this.id = id;
        this.lefetChopStick = lefetChopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!full) {
                think();
                if (lefetChopStick.pickUp(this, State.LEFT)) {

                    if (rightChopStick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopStick.putDown(this, State.RIGHT);
                    }
                    lefetChopStick.putDown(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return full;
    }

    public int getEatingCount() {
        return eatingCount;
    }

    public void think() throws InterruptedException {
        System.out.println(this + " is thinking!");
        Thread.sleep(random.nextInt(1000));
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " is eating!");
        Thread.sleep(random.nextInt(1000));
        eatingCount++;
    }

    @Override
    public String toString() {
        return "Philosspher " + id;
    }
}
