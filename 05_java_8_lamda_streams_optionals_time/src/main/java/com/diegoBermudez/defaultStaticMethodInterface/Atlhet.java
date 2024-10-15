package com.diegoBermudez.defaultStaticMethodInterface;

public class Atlhet extends Person implements Run{

    public Atlhet(String name, int age) {
        super(name, age);
    }

    @Override
    public void starts() {
        System.out.println("I had to implement this method myself as an athlet, because there was the diamond problem, startingggggg");
    }

    @Override
    public void stops() {
        System.out.println("I had to implement this method myself as an athlet, because there was the diamond problem, stoppingggggggggg");
    }
}
