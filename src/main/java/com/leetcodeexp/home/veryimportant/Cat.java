package com.leetcodeexp.home.veryimportant;

@VeryImportant
public class Cat {

    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void meow() {
        System.out.println("Meow!");
    }

    public void eat() {
        System.out.println("Munch");
    }
}
