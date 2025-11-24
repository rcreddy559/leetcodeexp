package com.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeakHashMap {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ravi", 44),
                new Person("Shobha", 39),
                new Person("Divija", 11),
                new Person("Gnanasree", 4));
        Collections.sort(persons, new AgeComparator());
        System.out.println(persons);
    }
}

class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person x, Person y) {
        return x.getName().compareTo(y.getName());
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person x, Person y) {
        return Integer.compare(x.getAge(), y.getAge());
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}