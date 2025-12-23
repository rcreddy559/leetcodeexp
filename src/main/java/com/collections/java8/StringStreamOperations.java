package com.collections.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreamOperations {

    // Count the occurrences of each character in a string
    public static Map<Character, Long> countCharacterOccurrences(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Find the first non-repeated character in a string
    public static Optional<Character> findFirstNonRepeatedCharacter(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    // Reverse a string using Stream operations
    public static String reverseString(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }

    // Check if two strings are anagrams using Streams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Long> map1 = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> map2 = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map1.equals(map2);
    }

    public static void main(String[] args) {
        String testStr = "programming";

        System.out.println("Character occurrences: " + countCharacterOccurrences(testStr));
        System.out.println("First non-repeated char: " + findFirstNonRepeatedCharacter(testStr));
        System.out.println("Reversed string: " + reverseString(testStr));
        System.out.println("Are 'listen' and 'silent' anagrams? " + areAnagrams("listen", "silent"));
    }
}
