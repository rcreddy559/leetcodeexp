package com.collections.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeGroupingDemo {
    public static void main(String[] args) {
        // 1. Create a list of Employee objects
        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "Alice", 60000.0, "HR"),
                new Employee(102, "Bob", 75000.0, "IT"),
                new Employee(103, "Charlie", 62000.0, "HR"),
                new Employee(104, "David", 85000.0, "IT"),
                new Employee(105, "Eve", 50000.0, "Sales"),
                new Employee(106, "Frank", 90000.0, "IT"));

        // 2. Use Java Stream to group employees by department
        // Collectors.groupingBy takes a Function (Employee::getDepartment)
        // to determine the key for the grouping.
        Map<String, List<Employee>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // 3. Print the result
        System.out.println("Employees Grouped by Department:");

        employeesByDepartment.forEach((department, employees) -> {
            System.out.println("\n--- Department: " + department + " ---");
            employees.forEach(System.out::println);
        });

        // find average salary by department
        Map<String, Double> averageSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage Salary by Department:");
        averageSalaryByDepartment.forEach((department, avgSalary) -> System.out
                .println("Department: " + department + ", Average Salary: " + avgSalary));
        // find all employees average salary
        double averageSalary = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average Salary of All Employees: " + averageSalary);
    }

}

class Employee {
    private String name;
    private double salary;
    private String department;
    private int id;

    // Constructor
    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + '}';
    }

    // Override equals and hashCode if necessary
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0)
            return false;
        if (id != employee.id)
            return false;
        if (!name.equals(employee.name))
            return false;
        return department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + department.hashCode();
        result = 31 * result + id;
        return result;
    }
}
