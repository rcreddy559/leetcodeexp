package com.pros;

public class Subarray {
    /*
     * Maximum Sum Subarray of Size K
     * Problem: Given an array of integers and a number k, find the maximum sum of
     * any contiguous subarray of size k.
     * Example: Input: [1, 4, 2, 10, 2, 3, 1, 0, 20], k = 4 → Output: 24 (sum of [4,
     * 2, 10, 2]).
     * Approach: Use a fixed-size window of length k and slide it across the array,
     * updating the maximum sum as you go.
     */
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE, windowSum = Integer.MIN_VALUE;
        int windowStart = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i]; // Add next element

            if (i >= k - 1) { // When we hit the window size
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // Remove the element leaving the window
                windowStart++; // Slide the window ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubarray(new int[] { 2, 1, 5, 1, 3, 2 }, 3)); // Output: 9
        System.out.println(findMaxSumSubarray(new int[] { 2, 3, 4, 1, 5 }, 2)); // Output: 7
System.out.println(findMaxSumSubarray(new int[] { 2, 3, 4, 1, 5 }, 2)); // Output: 7
        };
    }