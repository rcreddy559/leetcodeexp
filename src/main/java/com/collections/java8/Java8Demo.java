package com.collections.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        System.out.println("Java 8 features demo");
        countNumberOfStringOccurrence();
    }

    /**
     * Removes duplicates from a list of strings using Java 8 Stream API.
     */
    static void removeDuplicatesFromList() {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "kiwi");

        // Using Java 8 Stream to remove duplicates
        List<String> distinctItems = items.stream()
                .distinct()
                .collect(Collectors.toList());

        var setList = new HashSet<>(items);
        System.out.println("setList: " + setList);
        System.out.println("Original List: " + items);
        System.out.println("Distinct List: " + distinctItems);
    }

    /**
     * Finds common elements between two lists of strings using Java 8 Stream API.
     */
    static void findCommonElementsInTwoLists() {
        String s1[] = { "apple", "banana", "kiwi", "kiwi" };

        List<String> list1 = List.of(s1);
        List<String> list2 = List.of("banana", "orange", "kiwi", "grape");

        // Finding common elements using Java 8 Stream
        List<String> commonItems = list1.stream()
                .filter(list2::contains)
                .distinct()
                .toList();

        System.out.println("Common Items: " + commonItems);
    }

    /**
     * Counts the number of integers greater than 5 in a list using Java 8 Stream
     * API.
     */
    static void countIntegerNumberOfElementsGreaterThanFiveNumber() {
        List<Integer> numbIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = numbIntegers.stream()
                .filter(num -> num > 5)
                .count();

        System.out.println("Count of numbers greater than 5: " + count);
    }

    static void countNumberOfStringOccurrence() {
        String[] words = { "apple", "banana", "apple", "orange", "apple", "apple", "banana", "apple", "orange", null,
                "banana", "kiwi", "kiwi", "kiwi" };
        Map<String, Long> map = Arrays.stream(words).filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("String occurrences: " + map);
    }
}