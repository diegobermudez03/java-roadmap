package com.diegoBermudez.streamsAPI;

public class Person {
    private String name;
    private int age;
    private boolean male;

    public Person(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    @Override
    public String toString(){
        return "Hi, I'm " + name + " and I'm " + age + " years old";
    }
}
