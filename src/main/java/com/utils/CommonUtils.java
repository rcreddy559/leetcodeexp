package com.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {
        public static List<Employee> getEmployees() {
                List<Employee> employees = new ArrayList<>();
                employees.add(new Employee("E001", "John", "Doe", "john.doe@example.com", "555-1234",
                                "IT", "Software Engineer", 75000.0, new Date(120, 0, 1), true,
                                Arrays.asList(new Address(20,517124, "Main Street", "New York", "New York", "USA"))));

                employees.add(new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "555-5678",
                                "HR", "HR Manager", 85000.0, new Date(118, 5, 15), true, 
                                                Arrays.asList(new Address(34, 517124, "Main Street", "New York", "New York", "USA"))););

                employees.add(new Employee("E003", "Bob", "Johnson", "bob.johnson@example.com", "555-9012",
                                "Sales", "Sales Representative", 65000.0, new Date(121, 3, 22), false,
                                Arrays.asList(new Address(65, 517124, "Main Street", "New York", "New York", "USA"))););

                employees.add(new Employee("E004", "Alice", "Williams", "alice.williams@example.com", "555-3456",
                                "Finance", "Accountant", 70000.0, new Date(119, 11, 30), true,
                                Arrays.asList(new Address(11, 517124, "Main Street", "New York", "New York", "USA"))););

                employees.add(new Employee("E005", "Charlie", "Brown", "charlie.brown@example.com", "555-7890",
                                "Marketing", "Marketing Specialist", 68000.0, new Date(122, 7, 5), true,
                                Arrays.asList(new Address(20, 89834, "test", "test2", "test4", "ioioioioo"))));

                return employees;
        }

        public static List<Integer> getListOfIntegers() {
                return List.of(90901, 2456, 3111, 45644, 7865, 906, 67, 568, 339, 103);
        }

        public static List<String> getListOfElements() {
                List<String> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");
                list.add("D");
                list.add("E");
                list.add("F");

                return list;
        }
}
