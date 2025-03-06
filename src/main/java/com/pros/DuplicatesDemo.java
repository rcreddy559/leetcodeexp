package com.pros;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicatesDemo {

    public static void main(String[] args) {
        coutnDuplicates();
    }

    static void removeDuplicates() {
        List<Integer> dupNumbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 30, 40, 60, 80, 10);
        List<Integer> noDup = dupNumbers.stream().distinct().toList();
        System.out.println(dupNumbers);
        System.out.println(noDup);
    }

    static void coutnDuplicates() {
        List<Integer> dupNumbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 30, 40, 60, 80, 10);
        Map<Integer, Long> result = dupNumbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        List<Integer> dup = result.entrySet().stream()
                            .filter(v -> v.getValue() > 1)
                            .map(entity->entity.getKey())                    
                            .toList();
        System.out.println(dup);

    }

    static void getAllDuplicates() {
        String[] froots = { "Green", "Yellow", "Yellow", "Green", "Orange", "Blood Orange", "Red", "Red", "Green" };
        Set<String> uniqueNames = new HashSet<>();
        List<String> list = Stream.of(froots).filter(n -> !uniqueNames.add(n)).toList();
        for (String n : uniqueNames) {
            System.out.printf("%s, ", n);
        }
        System.out.println();
        for (String n : list) {
            System.out.printf("%s, ", n);
        }
        System.out.println();
        String[] distinct = Stream.of(froots).distinct().toArray(String[]::new);
        for (String s : distinct) {
            System.out.printf("%s, ", s);
        }
    }
}
