package com.collections.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStreamOperations {

    // Identify duplicate elements in a list
    public static <T> Set<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        return list.stream()
                .filter(e -> !seen.add(e))
                .collect(Collectors.toSet());
    }

    // Find the maximum and minimum values in a list
    public static Optional<Integer> findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }

    public static Optional<Integer> findMin(List<Integer> list) {
        return list.stream().min(Integer::compareTo);
    }

    // Calculate the sum and average of a list of numbers
    public static int calculateSum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static OptionalDouble calculateAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average();
    }

    // Find the frequency of each element in a list
    public static <T> Map<T, Long> findFrequency(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Remove duplicates from a list using Streams
    public static <T> List<T> removeDuplicates(List<T> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Find the second highest number in a list
    public static Optional<Integer> findSecondHighest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // Partition a list into even and odd numbers
    public static Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // Find the longest string in a list
    public static Optional<String> findLongestString(List<String> list) {
        return list.stream()
                .max(Comparator.comparingInt(String::length));
    }

    // Convert a List into a Map using Java Streams
    public static <T> Map<T, Integer> listToMapWithIndex(List<T> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        e -> list.indexOf(e),
                        (existing, replacement) -> existing));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 3, 8, 2, 5, 7);
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "strawberry", "grape");

        System.out.println("Duplicates: " + findDuplicates(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Sum: " + calculateSum(numbers));
        System.out.println("Average: " + calculateAverage(numbers));
        System.out.println("Frequency: " + findFrequency(numbers));
        System.out.println("Without duplicates: " + removeDuplicates(numbers));
        System.out.println("Second highest: " + findSecondHighest(numbers));
        System.out.println("Even/Odd partition: " + partitionEvenOdd(numbers));
        System.out.println("Longest string: " + findLongestString(words));
    }
}
