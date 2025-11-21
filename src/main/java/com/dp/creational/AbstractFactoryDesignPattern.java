package com.dp.creational;

// Abstract Product
abstract class Vehicle {
    public abstract void printVehicle();
}

// Concrete Products
class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

// Abstract Factory
interface VehicleFactory {
    Vehicle createVehicle();
}

// Concrete Factories
class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

// Client (or user) class
class Client {
    private VehicleFactory vehicleFactory;

    public Client(VehicleFactory factory) {
        this.vehicleFactory = factory;
    }

    public Vehicle getVehicle() {
        return vehicleFactory.createVehicle();
    }
}

// Driver program
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        // Creating a two-wheeler vehicle
        Client pClient = new Client(new TwoWheelerFactory());
        Vehicle pVehicle = pClient.getVehicle();
        pVehicle.printVehicle();

        // Creating a four-wheeler vehicle
        pClient = new Client(new FourWheelerFactory());
        pVehicle = pClient.getVehicle();
        pVehicle.printVehicle();
    }
}
