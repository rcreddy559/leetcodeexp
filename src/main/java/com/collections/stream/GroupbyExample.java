package com.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupbyExample {
    public static void main(String ...args) {
        List<String> fruits = Arrays.asList("Mango", "Orange", "Orange", "Jackfruit",
                "Jackfruit", "Jackfruit", "Mango", "Mango", "Mango", "Coconut", "Coconut", "Coconut", "Coconut");
        Map<String, Long> fruitsFrequency = fruits.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

                System.out.println(fruitsFrequency);
    }
}