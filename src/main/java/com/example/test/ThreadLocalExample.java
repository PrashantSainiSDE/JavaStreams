package com.example.test;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();

        // Simulate a user landing on the webpage
        Long userId = 12345L;
        Long userId1 = 56789L;

        // Handle the request in a new thread
        Thread requestThread = new Thread(() -> {
            System.out.println("Started thread for "
            + userId);
            userIdThreadLocal.set(userId);
            // Process my logic
            // Database call
            System.out.println("Completed logic for " + userIdThreadLocal.get());
            // Good coding practice to remove threadlocal object
            userIdThreadLocal.remove();
            System.out.println("Removed " + userIdThreadLocal.get());
        });

        Thread requestThread1 = new Thread(() -> {
            System.out.println("Started thread for "
                    + userId1);
            userIdThreadLocal.set(userId1);
            // Process my logic
            // Database call
            System.out.println("Completed logic for " + userIdThreadLocal.get());
            // Good coding practice to remove threadlocal object
            userIdThreadLocal.remove();
            System.out.println("Removed " + userIdThreadLocal.get());
        });

        requestThread.start();
        requestThread1.start();

        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread objThread3 = new Thread(() -> {
            inheritableThreadLocal.set("Youtube");
            userIdThreadLocal.set(12344557L);
            System.out.println(userIdThreadLocal.get());

            Thread objThread4 = new Thread(() -> {
                System.out.println(inheritableThreadLocal.get());
                System.out.println(userIdThreadLocal.get());
            });
            objThread4.start();
        });
        objThread3.start();
    }
}
