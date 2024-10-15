package com.diegoBermudez.reflection;

import java.util.HashMap;
import java.util.Map;

public final class Student extends Person{

    private Map<String, Double> classes;
    private int code;
    public final String hobby;

    public Student(String name, int bornYear, int code, String hobby) {
        super(name, bornYear);
        this.code = code;
        this.hobby = hobby;
        this.classes = new HashMap<String, Double>();
    }

    public void greetings(){
        System.out.println("Hi, I'm " + super.name);
    }

    public int calculate(int amount){
        return amount*2;
    }

    static void whatsAPerson(int legs){
        System.out.println("A person is someone that is a person with " + legs + " legs");
    }

    public void addClass(String name, double grade){
        this.classes.put(name, grade);
    }

    public int getCode(){
        return this.code;
    }

    @Override
    public String toString(){
        return "class: " + super.name + " born: " + super.bornYear;
    }


}
