package com.leetcodeexp.home.veryimportant;

public class CreatingAnnotations {
    public static void main(String[] args) {
        Cat cat = new Cat("Garfield", 10);

        if (cat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("Very important!");
        } else {
            System.out.println("Not very important");

        }
    }
}
