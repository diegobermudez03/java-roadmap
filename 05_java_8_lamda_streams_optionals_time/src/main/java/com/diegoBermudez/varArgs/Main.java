package com.diegoBermudez.varArgs;

public class Main {
    public static void main(String[] args) {
        //basically like the rest operator in js, all the parameters are sent into an ARRAY parameter
        doSomething("hola como estas", "bien gracias y tu", "super bien, gracias");

        Student s1 = new Student("juAN DIEGO", 20);
        Student s2 = new Student("Gabriela", 19);
        Student s3 = new Student("julian", 22);
        Student s4 = new Student("laura", 23);
        System.out.println("--------------------------------------");
        //the varArgs parameter must be alwways the last parameter
        createClass("Physics", 20, s1, s2, s3, s4);

    }

    public static void doSomething(String ...sentences){
        System.out.println(sentences[0]);
        for(String s: sentences){
            System.out.println(s);
        }
    }

    public static void createClass(String className, int hour, Student...students){
        System.out.println("asignature " + className + " created at " + hour + " for:");
        for(Student s: students){
            System.out.println("    " + s.getName());
        }
        System.out.println("TOTAL STUDENTS: " + students.length);
    }
}
