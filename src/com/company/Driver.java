package com.company;

public class Driver extends Human {

    private double skill;

    public Driver(String name, double skill) {
        super(name);
        this.skill = skill;
    }

    public double getSkill() {
        return skill;
    }
}
