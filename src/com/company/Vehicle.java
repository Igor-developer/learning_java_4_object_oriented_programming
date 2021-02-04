package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Vehicle {

    private String make;
    private double speed;
    private int fuelTankVolume;
    private Driver driver;

    public Vehicle(String make, int speed, int fuelTankVolume) {
        this.make = make;
        this.speed = speed;
        this.fuelTankVolume = fuelTankVolume;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        System.out.println("Водитель " + this.make + " " + this.driver.getName() + " готов к поездке.");
    }

    public int getFuelTankVolume() {
        return fuelTankVolume;
    }

    public String getMake() {
        return make;
    }

    public double getSpeed() {
        return speed;
    }

    public Driver getDriver() {
        return driver;
    }

    public abstract void fueling();

    double run(int km) {

        return (60 * km) / (speed *  driver.getSkill());
    }

    public void runVehicle(int km){
        double time = run(km);
        time = new BigDecimal(time).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("Заезд стартовал!\nДистанция " + km
                + " км преодолена, время " + make + " составило " + time + " минут!");
    }

}
