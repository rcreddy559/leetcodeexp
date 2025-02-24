package com.pros;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.utils.CommonUtils;
import com.utils.Department;
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

        double maxSalay = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1)
                .collect(Collectors.toList()).get(0).getSalary();

        System.out.println(maxSalay);

        System.out.println(employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get()
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

    static void findNonRepeatingChars() {
        String str = "/users/ravichandrap/Documents/leetcodeexp";

        var first = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();
        System.out.println(first.orElse(null));
    }

    /*
     * Group by java Stream
     */
    static void groupByDepartment() {
        Map<String, List<Employee>> gropByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (String dep : gropByDepartment.keySet()) {
            System.out.println("-------------------------------------------");
            System.out.println(dep);
            System.out.println(gropByDepartment.get(dep));
        }

        Map<String, Long> grepuByDepartmentCounting = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        for (String dep : grepuByDepartmentCounting.keySet()) {
            System.out.println("==========================================");
            System.out.println(dep);
            System.out.println(grepuByDepartmentCounting.get(dep));
        }
    }

    static void groupByDepartment3rdParam() {
        Map<Double, Set<Employee>> gropByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toSet()));

        for (Double dep : gropByDepartment.keySet()) {
            System.out.println("-------------------------------------------");
            System.out.println(dep);
            // System.out.println(gropByDepartment.get(dep));
        }
    }

    // Example with sum of salaries per department
    static void sumSalariesPerDepartment() {
        Map<String, Double> sumSalariesPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        for (String dep : sumSalariesPerDept.keySet()) {
            System.out.println(dep + " : " + sumSalariesPerDept.get(dep));
        }
    }

    // Multi-level Grouping: Department and Age Range
    static void multiLevelGroupingDepartmentAndAgeRange() {
        Map<String, Map<String, List<Employee>>> multiLevelGroping = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(emp -> {
                    return emp.getAge() < 30 ? "Young" : emp.getAge() < 50 ? "Middle" : "Old";
                })));

        for (String dep : multiLevelGroping.keySet()) {
            System.out.println("=================");
            System.out.println(dep.toUpperCase());
            Map<String, List<Employee>> secondLevel = multiLevelGroping.get(dep);
            for (String ageName : secondLevel.keySet()) {
                System.out.println("----");
                System.out.println(ageName);
                List<Employee> secondList = secondLevel.get(ageName);
                secondList.forEach(
                        e -> System.out.println(e.getFirstName() + ", " + e.getLastName() + ": " + e.getAge()));

            }
        }
    }

    // Group by Department and Collect Names into a Set
    static void groupDepartmentAndCollectNamesSet() {
        Map<String, Set<String>> collect = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getFirstName, Collectors.toSet())));

        for (String dep : collect.keySet()) {
            System.out.println("--------");
            System.out.println(dep);
            collect.get(dep).forEach(System.out::println);
        }
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

    // Group by Department and Salary Statistics
    static void groupDepartmentSalaryStatistics() {
        Map<String, DoubleSummaryStatistics> collect = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));
        for (String dep : collect.keySet()) {
            System.out.println("==>" + dep);
            DoubleSummaryStatistics doubleSummaryStatistics = collect.get(dep);
            System.out.println(doubleSummaryStatistics.toString());
        }
    }

    public static void main(String[] args) {
        groupDepartmentSalaryStatistics();
    }
}
