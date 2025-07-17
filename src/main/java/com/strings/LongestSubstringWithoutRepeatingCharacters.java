package com.strings;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input = "abcabcbb";
        int length = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int[] charIndex = new int[256]; // Assuming ASCII

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            start = Math.max(start, charIndex[currentChar]);
            maxLength = Math.max(maxLength, end - start + 1);
            charIndex[currentChar] = end + 1;
        }

        return maxLength;
    }
}
