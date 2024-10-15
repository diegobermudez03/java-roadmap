package com.diegoBermudez.streamsAPI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFourth {

    public static void main(String[] args) {

        //SKIP AND LIMIT CAN BE USED AS PAGINATION, LIMIT AND FETCH
        getPersons().stream().skip(5).limit(10).forEach(System.out::println);


        System.out.println("-----------------------------------");
        //we can use limit for infinite generators
        List<Double> randomNums = Stream.generate(()->Math.random()*100).limit(10).toList();
        randomNums.forEach(System.out::println);


        System.out.println("-----------------------------------");
        //iterate is similar to generate, but this is acumulative
        List<Double> nums2 = Stream.iterate(1D, (num) -> num*2 ).limit(10).toList();
        nums2.forEach(System.out::println);


        System.out.println("-----------------------------------");
        //distinct eliminates duplicates, like in sql
        Arrays.stream(new int[]{5,6,10,8,5,10,6,12}).distinct().forEach(System.out::println);


        System.out.println("-----------------------------------");
        //peek, is same as a forEach but this is intermediate, not terminal, also, it's recommended just for logging
        Arrays.stream(new int[]{5,6,10,8,5,10,6,12}).peek(System.out::println).filter((n) -> n>2 && n<100).count();


        System.out.println("-----------------------------------");
        //take while / drop while
        //this receives the condition it will take to decide where it stops generating or when it starts
        Arrays.stream(new int[]{1,5,10,20,30,40,50,60,70,80,100}).takeWhile(n->n<50).forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        Arrays.stream(new int[]{1,5,10,20,30,40,50,60,70,80,100}).dropWhile(n->n<50).forEach(System.out::println);


        System.out.println("-----------------------------------");
        //Collect
        //in the other files we have already seen about collection, but here's more

        //we can pass as the method reference the constructor of the type of collection
        List<Person> personas = getPersons().stream().map(p->new Person(p.getName(), p.getAge()*2, p.isMale()))
                .collect(Collectors.toCollection(LinkedList::new));
        personas.forEach(System.out::println);


    }

    private static List<Person> getPersons(){
        return List.of(
                new Person("Juan", 20, true),
                new Person("Bubu bebe", 19, false),
                new Person("Luis", 80, true),
                new Person("Augusto", 21, true),
                new Person("Fernando", 42, true),
                new Person("Pablo", 38, true),
                new Person("Valentina", 14, false),
                new Person("Sara", 8, false),
                new Person("Luciano", 10, true),
                new Person("Lina", 17, false),
                new Person("Felipe", 25, true),
                new Person("Camilo", 49, true),
                new Person("Camila", 58, false),
                new Person("Orlando", 60, true)
        );
    }
}
