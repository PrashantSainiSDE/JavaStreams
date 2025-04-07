package com.stream.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1};
        System.out.println(mostFrequent(arr));
    }

    private static int mostFrequent(int[] arr) {
//       Mine
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int j : arr) {
//            if (freq.containsKey(j)) {
//                freq.put(j, freq.get(j) + 1);
//            } else {
//                freq.put(j, 1);
//            }
//        }
//        return freq.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

//        GPT
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return Collections.max(freqMap.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
}
