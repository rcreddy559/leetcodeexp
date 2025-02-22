package com.pros;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication.Running;

import com.utils.CommonUtils;
import com.utils.Product;

public class CodingExamples {

    private static void generateFibonacci(int n) {
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    private static void findMedianOfArray() {
        int[] my_array = { 1, 2, 3, 4, 5, 6 };
        int n = my_array.length;
        double median;
        System.out.println((n % 2) + ", : " + my_array[n / 2] + ":" + my_array[n / 2 + 1]);
        if (n % 2 == 1) {
            median = my_array[n / 2];
        } else {
            median = (my_array[n / 2] + my_array[n / 2 + 1]) / 2d;
        }
        System.out.println("Median is:" + median);
    }

    public static void findMaxConsecutiveOnes() {
        int[] nums = new int[] { 0, 1, 0, 0, 0, 0, 1, 1, 1, 1 };
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++; // Increment count if 1 is found
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // Reset count if 0 is found
            }
        }
        System.out.println(maxCount);
    }

    /*
     * Reverse alternate characters in a string efficiently
     */
    static void reverseAlternateiveChars() {
        String str = "Helloworld";
        System.out.println("Original String: " + str);
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i += 2) {
            var temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }
        System.out.println("after String: " + new String(charArray));
    }

    /*
     * Find the 3rd largest number in an array without sorting
     */
    static void find3rdLargestNumber() {
        int[] arr = { 432, 856, 17, 392, 684, 929, 234, 115, 763, 549 };
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        if (arr.length < 3) {
            System.out.println("Invalid Input");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }

        Arrays.stream(arr).sorted().forEach(n -> System.out.print(n + ", "));
        System.out.println("Third largest number is: " + third);

    }

    /*
     * Max Difference Between Adjacent Elements
     * Task: Find the maximum absolute difference between adjacent elements in a
     * sorted list.
     * Input: List<Integer>
     * Output: int
     * Example: [2, 4, 1, 0] → 3 (after sorting: [0, 1, 2, 4], max diff is 4-1=3)
     * 
     */
    static void maxDifferenceBetweenAdjacentElements() {
        int[] arr = { 2, 4, 1, 0 };

        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i - 1] - arr[i]);
        }

        int maxStream = IntStream.range(1, arr.length)
                .map(i -> arr[i - 1] - arr[i]).max().getAsInt();

        System.out.println(max);
        System.out.println(maxStream);
    }

    /*
     * Generate Fibonacci Sequence
     * Task: Generate the first N Fibonacci numbers using Streams.
     * Input: int n
     * Output: List<Long>
     * Example: n=6 → [0, 1, 1, 2, 3, 5]
     */
    static void fibonacciSequence() {
        int n = 6;
        int fib[] = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        System.out.println(Arrays.toString(fib));
    }

    /*
     * Reverse Words in String
     * Task: Reverse the order of words in a string using Streams.
     * Input: String
     * Output: String
     * Example: "Hello World Java" → "Java World Hello"
     */

    static void reverseWordsInString() {
        String str = "one two three foure five fix seven eight nine ten";
        String[] strArr = str.split(" ");
        int n = strArr.length - 1;

        for (int i = 0; i < strArr.length / 2; i++) {
            String tmp = strArr[i];
            strArr[i] = strArr[n];
            strArr[n] = tmp;
            n--;
        }

        System.out.println(Arrays.toString(strArr));
        StringBuffer sb = new StringBuffer();

        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i]).append(" ");
        }
        System.out.println(sb.toString());

        String revStr = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list;
                })).stream().collect(Collectors.joining(" "));

        System.out.println(revStr);
    }

    /*
     * Group by Length and Concatenate
     * Task: Group strings by length and concatenate them with a delimiter.
     * Input: List<String>, String delimiter
     * Output: Map<Integer, String>
     * Example: ["cat", "dog", "bird", "rat"], "-" → {3="cat-dog-rat", 4="bird"}
     */
    static void groupByLengthAndConcatenate() {
        String[] arr = { "cat", "dog", "bird", "rat" };
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
            int currentLen = arr[i].length();
            if (map.get(currentLen) == null) {
                map.put(currentLen, arr[i]);
            } else {
                map.put(currentLen, map.get(currentLen) + "-" + arr[i]);
            }
        }
        System.out.println(map);

        Map<Integer, String> collect = Stream.of(arr)
                .collect(Collectors.groupingBy(String::length, Collectors.joining("-")));
        System.out.println(collect);

    }

    /*
     * Custom Collector for Median
     * Task: Write a custom collector to find the median of a list of doubles.
     * Input: List<Double>
     * Output: Double
     * Example: [1.5, 2.5, 3.5, 4.5] → 3.0
     */
    static void customCollectorForMedian() {
        double[] nums = { 1.5, 2.5, 3.5, 4.5 };
        double median;
        int length = nums.length;
        if (length % 2 == 0) {
            median = (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        } else {
            median = nums[length / 2];
        }

        System.out.println(median);

    }

    /*
     * Rotate List N Times
     * Task: Rotate a list of integers N times to the right using Streams.
     * Input: List<Integer>, int n
     * Output: List<Integer>
     * Example: [1, 2, 3, 4, 5], n=2 → [4, 5, 1, 2, 3]
     */
    static void rotateListNTimes() {
        int[] nums = { 1, 2, 3, 4, 5 };
        int n = 2;

    }

    static void findLongestString() {
        String[] strings = { "apple", "banana", "kiwi", "grapefruit" };
        Optional<String> longestString = Stream.of(strings).max(Comparator.comparingInt(String::length));
        Optional<String> shortestString = Stream.of(strings).min(Comparator.comparingInt(String::length));
        System.out.println("longestString: " + longestString.orElse("no element is "));
        System.out.println("shortestString: " + shortestString.orElse("no element is "));
    }

    static void distinctGreaterThan5() {
        int[] nums = { 2, 4, 5, 6, 7, 8, 9 };

        Set<Integer> collect = IntStream.of(nums)
                .filter(num -> num > 5)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toSet());

        collect.forEach(n -> System.out.print(n + ","));

        List<Integer> numArr = Arrays.asList(2, 4, 5, 6, 7, 8, 9);

        List<Integer> collect2 = numArr.stream()
                .filter(n -> n > 5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println();
        collect2.forEach(n -> System.out.print(n + ","));
    }

    /*
     * Finding the Top N Elements in Each Group:
     * 
     * Problem: You have a list of products, each with a category and a price. Find
     * the top 3 most expensive products in each category.
     */

    static void findingTopNElementsEachGroup() {
        List<Product> products = CommonUtils.getProducts();
        int topN = 3;
        Map<String, List<Product>> collect = products.stream().collect(
                Collectors.groupingBy(Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                productList -> productList.stream()
                                        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                                        .limit(topN)
                                        .toList())));
        for (String s : collect.keySet()) {
            System.out.printf("----%s---------%n", s);
            List<Product> prod = collect.get(s);
            prod.forEach(System.out::println);

        }

    }

    /*
     * Calculating Running Totals:
     * 
     * Problem: Given a list of transaction amounts, calculate the running total for
     * each transaction.
     * 
     * Solution: This is tricky because it requires accessing previous elements in
     * the stream, which streams aren't designed for directly. You can use
     * IntStream.range and reduce for a more functional approach.
     */
    static void calculatingRunningTotals() {
        Double[] transactions = { 10.0, 20.0, 5.0, 15.0, 25.0 };
        double[] runningTotal = IntStream.range(0, transactions.length)
                .mapToDouble(i -> Stream.of(transactions)
                        .limit(i + 1)
                        .reduce(0.0, Double::sum))
                .toArray();
        System.out.println(Arrays.toString(runningTotal));
    }

    public static void main(String[] args) {
        calculatingRunningTotals();
    }
}
