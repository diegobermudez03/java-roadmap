package com.diegoBermudez.reflection;

public class Person {
    protected String name;
    protected int bornYear;

    public Person(String name, int bornYear) {
        this.name = name;
        this.bornYear = bornYear;
    }

    public String getName() {
        return name;
    }

    public int getBornYear() {
        return bornYear;
    }
}
