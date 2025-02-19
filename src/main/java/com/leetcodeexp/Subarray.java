package com.leetcodeexp;

public class Subarray {
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;
        int windowStart = 0;

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
    }
    
}