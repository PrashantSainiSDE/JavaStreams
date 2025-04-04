package com.example.test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PlatformThreadsExample {
private static final HttpClient client = HttpClient.newHttpClient();


    public static void main(String[] args) throws InterruptedException {
        final int numberOfThreads = 10_000_0;

        List<Thread> listThreads = new ArrayList<>();

        Runnable objRunnable = PlatformThreadsExample::CallAPI;

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = Thread.ofVirtual().unstarted(objRunnable);
            // CPU capacity and memory.
            // Platform threads typically have a large thread stack and other resources
//            thread.setDaemon(true);
            thread.setName("Thread " + i);
            thread.start();
            String str = String.format("Thread number %s", i);
            System.out.println(str);
            listThreads.add(thread);
        }

        for (Thread thr : listThreads) {
            thr.join();
            System.out.println(thr.getName() + " Completed");
        }
    }

    public static void CallAPI() {
//        // Simulate fetching data from URL
//        System.out.println("Fetching data from API");
//        try {
//            Thread.sleep(10000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Data fetched from API");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
