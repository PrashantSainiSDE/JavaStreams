package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildCard {
    // Method to print elements of a List<T>
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    // Method ot print elements of a List<?>
    public static void printWildCardList(List<?> list){
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        System.out.println("Printing stringList:");
        printList(stringList);
        System.out.println("\nPrinting integerList:");
        printList(integerList);

        System.out.println("\nPrinting wildcard stringList:");
        printWildCardList(stringList);
        System.out.println("\nPrinting wildcard integerList:");
        printWildCardList(integerList);
    }
}

// Generic question: type erasure