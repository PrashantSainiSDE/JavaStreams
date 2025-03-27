package com.example.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {
        // Map
        List<String> words = Arrays.asList("Hello", "World");

        // Using map to convert each word to its uppercase form
        List<String> uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("Using map: "+ uppercaseWords);

        // Flat Map
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));

        // Using flatmap to flatten the nested list
        List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).map(number -> number * 2).toList();

        System.out.println("Flattened List: "+ flattenedList);

    }
}
