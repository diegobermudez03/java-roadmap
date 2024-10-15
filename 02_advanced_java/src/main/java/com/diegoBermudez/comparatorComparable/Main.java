package com.diegoBermudez.comparatorComparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Comparator is an interface where we can Implement our logic of comparation
        Comparator<Integer> miCompa = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1%10 > o2%10 ? 1: -1;
            }
        };
        //or with lambda, better but right now since I don't know lambda very well, I won't do it
        //Comparator<Integer> miCompa = (o1, o2) -> o1%10 > o2%10 ? 1: -1;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(41,52,63,62,488,10));
        Collections.sort(numbers, miCompa);

        for(Integer i: numbers) System.out.println(i);


        //COMPARABLE, IS AN INTERFACE WE IMPLEMENT IN THE CLASS ITSELF, THAT WE'LL USE IN A LIST

        List<Student> students = new ArrayList<>();
        students.add(new Student("juan", 20));
        students.add(new Student("julian", 15));
        students.add(new Student("kevin", 26));
        students.add(new Student("stevan", 10));
        Collections.sort(students);
        for(Student s: students) System.out.println(s);
    }
}
