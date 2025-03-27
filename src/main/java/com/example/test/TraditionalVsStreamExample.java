package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TraditionalVsStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Traditional approach: Find sum of squares for even numbers
        int sumOfSquares = 0;
        for (int number : numbers) {
            if(number % 2 == 0 ){ // Filter even numbers
                int square = number * number; // Square the number
                sumOfSquares += square; // Add ot the sum
            }
        }

        System.out.println("Sum of squares (traditional): "+ sumOfSquares);

        //Java Streams approach: Find sum of squares for even numbers
        int sumOfSquaresStream = numbers.stream()
                .filter(number -> number % 2 == 0) // Filter even numbers
                .mapToInt(number -> number * number) // Square the number
                .sum(); // Sum the squared values

        System.out.println("Sum of squares (Java Stream): "+ sumOfSquares);


    }
}
