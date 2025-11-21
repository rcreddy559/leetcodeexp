package com.pros;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.utils.CommonUtils;
import com.utils.Employee;

public class StreamDemo {

    static List<Employee> employees;

    static {
        employees = CommonUtils.getEmployees();
    }

    /*
     * Get Max and Min Salary of Employees
     */
    public static void maximumSalary() {

        OptionalDouble maximumSalary = employees.stream().mapToDouble(Employee::getSalary).max();
        OptionalDouble minimumSalary = employees.stream().mapToDouble(Employee::getSalary).min();
        System.out.println("Maximum Salary: " + maximumSalary.getAsDouble());
        System.out.println("Maximum Salary: " + minimumSalary.getAsDouble());

        double maxSalay = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .limit(1)
                .collect(Collectors.toList())
                .get(0).getSalary();

        System.out.println(maxSalay);

        System.out.println(employees.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get()
                .getSalary());

        double maxSalary = 0;
        for (Employee e : employees) {
            maxSalary = Math.max(maxSalary, e.getSalary());
        }
        System.out.println(maxSalary);

    }

    static void printSecondHighestSalary() {
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(1)
                .map(Employee::getSalary).forEach(System.out::print);
    }

    static void salaryIncreaseBy() {
        List<Employee> emp = employees.stream().map(e -> {
            e.setSalary(e.getSalary() * 2);
            return e;
        }).toList();

        for (int i = 0; i < emp.size(); i++) {
            System.out.println(employees.get(i).getSalary() + " : " + emp.get(i).getSalary());
        }
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

    static void partitionedBySalary() {
        Map<Boolean, List<Employee>> bySalary = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() < 70000));
        for (boolean b : bySalary.keySet()) {
            System.out.println("==========================================");
            System.out.println(b);
            System.out.println(bySalary.get(b));
        }
    }

    public static void main(String[] args) {

    }
}
