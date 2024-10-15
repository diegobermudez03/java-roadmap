package com.diegoBermudez.defaultStaticMethodInterface;

public class Person extends Alive implements Eat, Walk{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        super.born();
    }

    @Override
    public void jump(int km) {
        System.out.println("lets jump like a person "  + km + " kilometers, and I'm " + name);
    }

    @Override
    public double prepare() {
        System.out.println("Let me prepare to walk, checking what's my heartbeat");
        return 15;
    }

    @Override
    public void myThing() {
        System.out.println("As a Human my thing is to be happy");
    }
}
