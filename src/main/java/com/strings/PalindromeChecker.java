package com.strings;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true; // An empty or null string can be considered a palindrome
        }

        // Convert to lowercase to make it case-insensitive
        String cleanedStr = str.toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            // Compare characters from both ends
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false; // Not a palindrome
            }
            left++; // Move left pointer forward
            right--; // Move right pointer backward
        }
        return true; // It's a palindrome
    }

    // A more robust version that ignores non-alphanumeric characters
    public static boolean isPalindromeAdvanced(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        String cleanedStr = str.toLowerCase();
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(cleanedStr.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(cleanedStr.charAt(right))) {
                right--;
            }

            if (left < right) { // Ensure pointers haven't crossed
                if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String testString = "radar";
        if (isPalindrome(testString)) {
            System.out.println(testString + " is a palindrome.");
        } else {
            System.out.println(testString + " is not a palindrome.");
        }
    }
}
