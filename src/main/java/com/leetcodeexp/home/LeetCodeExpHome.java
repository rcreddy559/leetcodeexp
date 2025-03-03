package com.leetcodeexp.home;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leetcodeexp.collections.SortingDemos;

@RestController
@RequestMapping("/home")
class LeetCodeExpHome {

    @GetMapping
    String home() {

        SortingDemos.sorting1();

        // ComparableDemo.mainTest();
        // testComparator();
        return "home";
    }

    void testComparator() {
        var list = Arrays.asList(
                new Employee("xxx", 101010),
                new Employee("cccc", 110),
                new Employee("aaaa", 102),
                new Employee("sssss", 106));
        list.forEach(System.out::println);
        System.out.println("\n");
        Collections.sort(list, new EmployeeSortByEmpNumber());
        list.forEach(System.out::println);
        System.out.println("------");
        System.out.println("\n");
        Collections.sort(list, new EmployeeSortByName());
        list.forEach(System.out::println);
    }
}

class Employee {

    private String name;
    private int empNumber;

    Employee(String name, int empNumber) {
        this.name = name;
        this.empNumber = empNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", empNumber=" + empNumber + "]";
    }

}

class EmployeeSortByEmpNumber implements Comparator<Employee> {

    @Override
    public int compare(Employee arg0, Employee arg1) {
        return Integer.compare(arg0.getEmpNumber(), arg1.getEmpNumber());
    }

}

class EmployeeSortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee arg0, Employee arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }

}
