package com.threads.semaphore;

import java.util.concurrent.Semaphore;

public class ParkingLot {
    final private static Semaphore semaphore = new Semaphore(5, true);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Parking(i)).start();
        }
    }

    static class Parking  implements Runnable {
        
        final private int i;

        Parking(int i) {
            this.i = i;
        }
        
        @Override
        public void run() {
            try {
                if (semaphore.tryAcquire(0)) {
                    System.out.println("Car " + i + " acquired the parking lot");
                    Thread.sleep(2000);
                    System.out.println("Car " + i + " released the parking lot");
                    semaphore.release();
                } else {
                    System.out.println("Parking lot is full");
                }
            } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
    }

}
