package com.company;

public class Truck extends Vehicle {

    private Passenger passenger;

    public Truck(String make, int speed, int fuelTankVolume) {
        super(make, speed, fuelTankVolume);
    }

    public void setPassenger(Passenger passenger) {
        if (this.passenger == null) {
            this.passenger = passenger;
            System.out.println("Пассажир " + this.passenger.getName() + " (вес "
                              + this.passenger.getWeight() + " кг) сел в грузовик.");
        } else if (this.passenger == passenger) {
            System.out.println("Пассажир " + this.passenger.getName() + " уже сидит в грузовике.");
        } else {
            System.out.println("Для ещё одного пассажира " + passenger.getName()
                    + " нет места, так как это двухместный грузовик!");
        }
    }
    @Override
    public void fueling() {
        System.out.println("Грузовик заправлен, в баке " + getFuelTankVolume() + " литров топлива!");
    }
    double run(int km) {

        return (60 * km) / ((5200 / (5200 + passenger.getWeight())) * getSpeed() *  getDriver().getSkill());
    }
}
