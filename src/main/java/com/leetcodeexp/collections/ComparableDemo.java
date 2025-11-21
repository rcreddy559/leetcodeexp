package com.leetcodeexp.collections;

import java.util.Arrays;
import java.util.Collections;

public class ComparableDemo {

    public static void mainTest() {

        var c1 = new Car(201, "model1", 2012);
        var c2 = new Car(211, "model1", 2012);
        var c3 = new Car(221, "model1", 2012);
        var list = Arrays.asList(c3, c1, c2);
        list.forEach(c -> {
            System.out.println(c.toString());
        });
        Collections.sort(list);
        System.out.println("\n");

        list.forEach(c -> {
            System.out.println(c.toString());
        });
    }
}

class Car implements Comparable<Car> {

    private int snNumber;
    private String model;
    private int yearOfMak;

    @Override
    public String toString() {
        return "Car [snNumber=" + snNumber + ", model=" + model + ", yearOfMak=" + yearOfMak + "]";
    }

    public void setSnNumber(int snNumber) {
        this.snNumber = snNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfMak(int yearOfMak) {
        this.yearOfMak = yearOfMak;
    }

    public int getSnNumber() {
        return snNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfMak() {
        return yearOfMak;
    }

    public Car(int snNum, String model, int yearOfMak) {
        this.snNumber = snNum;
        this.model = model;
        this.yearOfMak = yearOfMak;
    }

    @Override
    public int compareTo(Car arg0) {
        return Integer.compare(this.snNumber, arg0.snNumber);
    }

}