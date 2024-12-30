package com.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;

    private Semaphore sempahore = new Semaphore(3, true);

    public void download() {
        try {
            sempahore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sempahore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from web");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (var i = 0; i < 13; i++) {
            service.execute(new Runnable() {
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
