package com.diegoBermudez.instanceOfPatternMatch;

public class Pilot extends Person{
    private final int km;

    public Pilot(String name, int age, int km) {
        super(name, age);
        this.km = km;
    }
}
