package com.diegoBermudez.memoryManagement.objectPools;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> studentClasses;

    public Student(){
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void addClass(String studentClass){
        studentClasses.add(studentClass);
    }

    public void delete(){
        studentClasses = null;
    }

    @Override
    public String toString(){
        return "I'm " + this.name + " age "+ this.age;
    }
}
