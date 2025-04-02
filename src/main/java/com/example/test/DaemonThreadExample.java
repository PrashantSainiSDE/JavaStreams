package com.example.test;

public class DaemonThreadExample {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");

        Thread objThread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
        });
        objThread2.start();

        Runnable objRunnable = () -> {
            System.out.println("Thread 3 started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 ended");
        };

        Thread objThread3 = new Thread(objRunnable, "Runnable Thread");
        objThread3.setDaemon(true);
        objThread3.start();

        System.out.println("Main Thread ended");
    }
}
