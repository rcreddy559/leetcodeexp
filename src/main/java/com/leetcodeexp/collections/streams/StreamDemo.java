package com.leetcodeexp.collections.streams;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.utils.CommonUtils;
import com.utils.Employee;

public class StreamDemo {

    public static void maximumSalary() {
        List<Employee> employees = CommonUtils.getEmployees();

        OptionalDouble maximumSalary = employees.stream().mapToDouble(Employee::getSalary).max();
        OptionalDouble minimumSalary = employees.stream().mapToDouble(Employee::getSalary).min();
        System.out.println("Maximum Salary: " + maximumSalary.getAsDouble());
        System.out.println("Maximum Salary: " + minimumSalary.getAsDouble());

        double maxSalay = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1)
                .collect(Collectors.toList()).get(0).getSalary();

        System.out.println(maxSalay);

        System.out.println(employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get()
                .getSalary());

    }

    static void printSecondHighestSalary() {
        List<Employee> employees = CommonUtils.getEmployees();
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(1)
                .forEach(System.out::println);
    }

    static void printSecondHighestInteger() {
        List<Integer> integers = CommonUtils.getListOfIntegers();
        integers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
    }

    static void removeAlternativeElements() {
        List<String> elements = CommonUtils.getListOfElements();
        elements.stream().filter(e -> elements.indexOf(e) % 2 == 0).forEach(System.out::println);
    }

    static void vowelChecker() {
        String str = "HelloWorld";

        // Lambda expression to check if a character is a vowel
        java.util.function.Predicate<Character> isVowel = c -> "aeiouAEIOU".indexOf(c) != -1;

        // Stream to process each character and check if it's a vowel
        str.chars().forEach(c -> {
            char ch = (char) c;
            System.out.println(ch + " is " + (isVowel.test(ch) ? "a vowel" : "not a vowel"));
        });
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

    public static void main(String[] args) {
        findMaxConsecutiveOnes();
    }
}
