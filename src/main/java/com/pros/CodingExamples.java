package com.pros;

import java.util.Arrays;
import java.util.stream.IntStream;

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

    public static void main(String[] args) {
        maxDifferenceBetweenAdjacentElements();
    }
}
