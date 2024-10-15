package com.diegoBermudez.generics;

public class Dog extends Vivid implements Animal{
    @Override
    public void makeSoung() {
        System.out.println("wouf");
    }

    @Override
    public void sleep() {
        System.out.println("zzzz");
    }
}
