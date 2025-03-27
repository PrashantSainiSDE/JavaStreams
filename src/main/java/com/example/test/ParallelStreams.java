package com.example.test;

import java.util.Arrays;

public class ParallelStreams {
    public static void main(String[] args) {

        int[] intArray = new int[1000000]; // 1 Million Size
        Arrays.fill(intArray, 2);

        // Calculate the sum of squares using  sequential stream
        long startTime = System.currentTimeMillis();

        long sum = Arrays.stream(intArray)
                .mapToLong(num -> num * num)
                .sum();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        // Calculate the sum of squares using parallel stream

        long startTimeP = System.currentTimeMillis();

        long sumP = Arrays.stream(intArray)
                .parallel()
                .mapToLong(num -> num * num)
                .sum();

        long endTimeP = System.currentTimeMillis();
        System.out.println(endTimeP - startTimeP);
    }
}
