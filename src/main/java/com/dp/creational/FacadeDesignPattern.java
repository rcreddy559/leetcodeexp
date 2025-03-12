package com.dp.creational;

interface Vehicle {
    public abstract void print();
}

class TwoWheeler implements Vehicle {
    @Override
    public void print() {
        System.out.println("I am two wheeler!!");
    }
}

class FourWheeler implements Vehicle {
    @Override
    public void print() {
        System.out.println("I am four wheeler!!");
    }
}

class VehicleFacade {
    private TwoWheeler twoWheeler;
    private FourWheeler fourWheeler;

    public VehicleFacade() {
        this.twoWheeler = new TwoWheeler();
        this.fourWheeler = new FourWheeler();
    }

    public void createTwoWheeler() {
        this.twoWheeler.print();
    }

    public void createFourWheeler() {
        this.fourWheeler.print();
    }
}

class Client {
    private VehicleFacade vehicleFacade;

    public Client() {
        this.vehicleFacade = new VehicleFacade();
    }

    public void createFourWheeler() {
        this.vehicleFacade.createFourWheeler();
    }

    public void createTwoWheeler() {
        this.vehicleFacade.createTwoWheeler();
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args) {
        Client client = new Client();
        client.createFourWheeler();
        client.createTwoWheeler();
    }
}
