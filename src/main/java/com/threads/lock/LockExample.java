package com.threads.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {

    Lock lock = new ReentrantLock();
    int count = 0;

    public void increment() {
        
    }
    
}


public class LockExample {
    public static void main(String[] args) {
        
    }
}
