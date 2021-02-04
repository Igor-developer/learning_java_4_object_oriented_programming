package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Airplane extends Vehicle {

    private double takeOffTime;
    private double landingTime;

    public Airplane(String make, int speed, int fuelTankVolume, double takeOffTime, double landingTime) {
        super(make, speed, fuelTankVolume);
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
    }

    @Override
    public void fueling() {
        System.out.println("Заправлять самолёт имеет право только специально обученная команда. " +
                "Самолёт передан на заправку. Залито " + getFuelTankVolume() + " литров керосина.");
    }

    @Override
    public void runVehicle(int km) {
        double time = takeOffTime + run(km) + landingTime;
        time = new BigDecimal(time).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("Дистанция " + km + " км преодолена, время "
                + getMake() + " составило " + time + " минут!");
    }
}
