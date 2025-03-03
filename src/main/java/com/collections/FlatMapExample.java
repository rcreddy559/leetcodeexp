package com.collections;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfListONums = Arrays.asList(
            Arrays.asList("one", "tow", "three", "four"),
                Arrays.asList("five", "six", "sevent", "eight"));

        List<String> listOfNums = Arrays.asList("one", "tow", "three", "four", "five", "six", "sevent", "eight");
                    
        var uppder = listOfNums.stream().map(String::toUpperCase).toList();
        var uppderFlatMap = listOfListONums.stream().flatMap(List::stream).map(String::toUpperCase).toList();
        
        System.out.println(uppder);
        System.out.println(uppderFlatMap);
        // List<String> listNull = Arrays.asList(null);
        // System.out.println(listNull);
        String name = "Divija";
        System.out.println(name);

        double result = 10 + 30 + (30 / 50.30 * 30);
        System.out.println(result);
        double fractions = 30 / 40.2 + 90 / 50.99 + 78 / 99.7;
        System.out.println(fractions);
    }
}
