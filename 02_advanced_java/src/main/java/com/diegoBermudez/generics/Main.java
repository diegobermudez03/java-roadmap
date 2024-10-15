package com.diegoBermudez.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //GENERIC CLASSES
        Printer<Dog, ArrayList<Integer>> intPrinter = new Printer<>(new Dog(), new ArrayList<>());
        Printer<Cat, HashSet> stringPrinter = new Printer<>(new Cat(), new HashSet<>());
        intPrinter.print();
        stringPrinter.print();


        //GENERIC METHODS
        String phrase = shout("hello", 23);
        shout(intPrinter, "jajajaa");
        call(new Cat());


        //WILDCARD
        //wild cards allow any type, for instance, we can say like, we return ANY type of list, so you expect any type.
        //so in the method we can like return a list of Animals, or Cars, or Humands, depending on conditions
        //and the receiver must know that, it will simply receive a list of objects of any type, he must convert
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        printList(cats);

        List<Animal> aux = (List<Animal>) wildCard2(Arrays.asList(41, 52, 63, 10));

        //LOWER BOUNDED PARAMETERS
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        printL(animals);

        //MANDATORY MANUALLY SPECIFIED GENERIC METHOD
        InnerClass.<Integer>myMethod();

    }

    //It seems, the only way to call our manually specified generic types
    //which are not infered by parameters, we can only do it if they are part of another class
    class InnerClass{
        public static <T> T myMethod(){
          return null;
        }
    }


    private static List<?> wildCard2(List<Number> numbers){
        return new ArrayList<Animal>(Arrays.asList(new Cat(), new Dog()));
    }

    private static void printL(List<? super Cat> myList){
        for(Object o : myList){
            System.out.println(o);
        }
    }
    private static void printList(List<? extends Animal> myList){
        for(Object o : myList){
            System.out.println(o);
        }
    }

    private static <T, V> T shout(T thingToShoud, V otherThing){
        System.out.println(thingToShoud +  " " + otherThing + "!!!!!!!!!");
        return thingToShoud;
    }

    private static <T extends Animal> void call(T animal){
        animal.sleep();
    }


}
