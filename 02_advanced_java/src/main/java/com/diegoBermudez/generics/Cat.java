package com.diegoBermudez.generics;

public class Cat extends Vivid implements Animal{
    @Override
    public void makeSoung() {
        System.out.println("miau");
    }

    @Override
    public void sleep() {
        System.out.println("grrrr");
    }
}
