package com.example.test;

// Race condition example
// Remove or add AtomicInteger class to see the result

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

//    Other way to solve this problem
//    public synchronized void increment() {
//        count++;
//    }

    public int getCount() {
        return count.get();
    }
}

public class Atomic {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Thread 1
        new Thread(() -> {
            System.out.println("Thread 1 Started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 1 Completed");
        }).start();

        // Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 Started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 2 Completed");
        }).start();

        //Give threads time to complete
        try {
        Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final Count: " + sharedCounter.getCount());
    }
}
