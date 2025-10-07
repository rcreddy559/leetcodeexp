package com.pros;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.utils.Person;

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
        for (Map.Entry<Boolean, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    static void isAdultsOrMinors() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 17),
                new Person("Bob", 20),
                new Person("Charlie", 15),
                new Person("David", 19));
        Map<Boolean, List<Person>> collect = people.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 18));
        System.out.println("ADULATS: " + collect.get(true));
        System.out.println("Minors: " + collect.get(false));
    }

    static void countByFilter() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry");
        long count = words.stream().filter(w -> w.startsWith("a")).count();
        System.out.println("starts with a: " + count);
    }

    static void flatMapExample() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f"));
        List<String> collect = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void main(String[] args) {
        flatMapExample();
    }
}
