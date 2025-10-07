package com.generics;

import java.util.ArrayList;
import java.util.List;

interface Car {
    public String getCarName();
}

class BMW implements Car {
    @Override
    public String getCarName() {
        return "BMW";
    }
}

class Audi implements Car {
    @Override
    public String getCarName() {
        return "Audi";
    }
}

class AudiAxel extends Audi {

    @Override
    public String getCarName() {
        return "AudiAxel";
    }
}

public class CarDemo {

    public static void main(String[] args) {
        Car myCar = new BMW();
        System.out.println(myCar.getCarName());

        myCar = new Audi();
        System.out.println(myCar.getCarName());

        myCar = new AudiAxel();
        System.out.println(myCar.getCarName());

        List<? super Car> cars = new ArrayList<>();
        cars.add(new BMW());
        cars.add(new Audi());
        cars.add(new AudiAxel());

        List<? extends AudiAxel> audiCars = List.of(new AudiAxel(), new AudiAxel());

        // You can read elements from the list
        for (AudiAxel audi : audiCars) {
            System.out.println(audi.getCarName());
        }

    }
}
