package com.threads.diningphilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophersExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
        Philosopher[] philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
        Chopstick[] chopsticks;
        try {
            chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPICSTICKS];

            for (int i = 0; i < Constants.NUMBER_OF_CHOPICSTICKS; i++) {
                chopsticks[i] = new Chopstick(i);
            }

            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i],
                        chopsticks[(i + 1) % Constants.NUMBER_OF_PHILOSOPHERS]);
                service.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
            while (!service.isTerminated())
                Thread.sleep(1000);

            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + " eat# " + philosopher.getEatingCount() + " times");
            }
        }
    }
}
