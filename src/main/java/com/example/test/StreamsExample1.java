package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

class Transaction {
    private String category;
    private int amount;

    public Transaction(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }
    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}

public class StreamsExample1 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Grocery", 2500),
                new Transaction("Entertainment", 500),
                new Transaction("Grocery",1500),
                new Transaction("Utilities", 1200),
                new Transaction("Utilities", 500),
                new Transaction("Entertainment", 1500)
        );

        // Use case1: Calculate the total amount spent on groceries
        int amount = transactions.stream()
                .filter(t -> t.getCategory().equals("Grocery"))
                .mapToInt(Transaction::getAmount)
                .sum();
        System.out.println(amount);

        // Use case2: Find the average expense across all categories
        double average = transactions.stream()
                .mapToDouble(Transaction::getAmount).average().orElse(0.0);

        System.out.println(average);
    }
}
