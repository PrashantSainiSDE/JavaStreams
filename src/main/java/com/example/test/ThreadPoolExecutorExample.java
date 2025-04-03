package com.example.test;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample
{
    public static void main(String[] args) throws InterruptedException {

        // Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // Thread Pool Executor
        ExecutorService threadPoolExecutorObject =
                new ThreadPoolExecutor(1,
                        5,
                        0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(10));

        for (int i = 1; i <= 13; i++) {
            final int taskId = i;
            threadPoolExecutorObject.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread Pool Executor " +
                        "Thread Task " + taskId +
                        " executed by Thread: " +
                        Thread.currentThread().getName());
            });
        }
        threadPoolExecutorObject.shutdown();
    }
}
