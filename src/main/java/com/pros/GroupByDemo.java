package com.pros;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.utils.CommonUtils;
import com.utils.Employee;

/**
 * This class demonstrates various examples of using Java streams to perform
 * grouping operations on a list of employees.
 * The code includes methods to find the first non-repeated character in a
 * string, group employees by department,
 * group employees by department with a specified third parameter, calculate the
 * sum of salaries per department,
 * perform multi-level grouping by department and age range, group employees by
 * department and collect names into a set,
 * and group employees by department and calculate salary statistics.
 */
public class GroupByDemo {
    static List<Employee> employees;

    static {
        employees = CommonUtils.getEmployees();
    }
    /*
     * Find the first Non-Repeated charector in string using Java streams
     */

    static void findNonRepeatingChars() {
        String str = "/users/ravichandrap/Documents/leetcodeexp";

        var first = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();
        System.out.println(first.orElse(null));
    }

    /**
     * Finds and prints the count of each word in a sample string using Java
     * streams.
     */
    static void findWordsCount() {
        String str = "This is a test string with several words. find the count of each word in this string find the count of each word in this string";

        // Split on whitespace and punctuation, but keep apostrophes and hyphens within
        // words
        Map<String, Long> wordCount = Arrays.stream(str.split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
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
        findWordsCount();
    }
}
