package com.designpattern.structuraldesignpattern;

public class BridgePattern {
    public static void main(String[] args) {
        Vehicle car = new Car(new Produce(), new Assembel());
        car.manufactor();

        Vehicle bike = new Bike(new Produce(), new Assembel());
        bike.manufactor();

    }
}

interface Workshop {
    void work();
}

abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract public void manufactor();
}

class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    public void manufactor() {
        System.out.println("Car");
        workshop1.work();
        workshop2.work();
    }
}

class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufactor() {
        System.out.println("Bike work is going on!");
        workshop1.work();
        workshop2.work();
    }
}

class Produce implements Workshop {
    @Override
    public void work() {
        System.out.println("Producing...");
    }
}

class Assembel implements Workshop {

    @Override
    public void work() {
        System.out.println("Assemnbling....");
    }

}
