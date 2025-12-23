package com.collections.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectStreamOperations {

    // Employee class for demonstration
    static class Employee {
        private String name;
        private String department;
        private int salary;

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', dept='" + department + "', salary=" + salary + "}";
        }
    }

    // Sort a list of objects based on a specific field
    public static List<Employee> sortBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static List<Employee> sortByName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    // Group objects by a specific field (e.g., department)
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    // Convert List to Map (employee name as key, employee as value)
    public static Map<String, Employee> employeeListToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Function.identity(),
                        (existing, replacement) -> existing));
    }

    // Get average salary by department
    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 75000),
                new Employee("Bob", "HR", 55000),
                new Employee("Charlie", "IT", 80000),
                new Employee("David", "Finance", 70000),
                new Employee("Eve", "HR", 60000));

        System.out.println("Sorted by salary:");
        sortBySalary(employees).forEach(System.out::println);

        System.out.println("\nGrouped by department:");
        groupByDepartment(employees).forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps);
        });

        System.out.println("\nAverage salary by department:");
        getAverageSalaryByDepartment(employees).forEach((dept, avg) -> {
            System.out.println(dept + ": " + avg);
        });
    }
}
