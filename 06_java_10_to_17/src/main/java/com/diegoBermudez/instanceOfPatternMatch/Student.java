package com.diegoBermudez.instanceOfPatternMatch;

public class Student extends Person{

    private int code;
    public Student(String name, int age, int code) {
        super(name, age);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
