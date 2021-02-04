package com.company;

public class Bicycle extends Vehicle {

    public Bicycle(String make, int speed) {
        super(make, speed, 0);
    }

    @Override
    public void fueling() {
        System.out.println("Велосипед не нужно заправлять!");
    }

}
