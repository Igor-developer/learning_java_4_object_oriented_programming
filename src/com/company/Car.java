package com.company;

public class Car extends Vehicle {

    public Car(String make, int speed, int fuelTankVolume) {
        super(make, speed, fuelTankVolume);
    }

    @Override
    public void fueling() {
        System.out.println("Автомобиль заправлен, в баке " + getFuelTankVolume() + " литров топлива!");
    }

}
