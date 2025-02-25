package com.pros;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {

    /*
     * Partition Strings Starting with a Vowel
     * Partition a list of strings based on whether they start with a vowel (a, e,
     * i, o, u).
     */

    static void partitionStringsStartingWithVowel() {
        List<String> words = Arrays.asList("apple", "bat", "elephant", "cat", "igloo", "dog", "jkmama");
        Map<Boolean, List<String>> result = words.stream()
                .collect(Collectors.partitioningBy(a -> "aeiou".indexOf(Character.toLowerCase(a.charAt(0))) > 0));
        for (boolean flag : result.keySet()) {
            System.out.println(flag);
            System.out.println(result.get(flag));
        }
    }

    public static void main(String[] args) {
        partitionStringsStartingWithVowel();
    }
}
