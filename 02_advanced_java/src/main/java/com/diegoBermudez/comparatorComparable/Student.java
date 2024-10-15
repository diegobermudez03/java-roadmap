package com.diegoBermudez.comparatorComparable;

public class Student implements Comparable<Student>{

    int age;
    String name;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - ((Student)o).age;
    }
}
