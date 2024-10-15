package com.diegoBermudez.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        //optionals is same as Nullables in C# or Dart, even when Java allows null values on any reference type
        //this is a container  that obligates us to check if it's null or not


        //without optionals
        Cat cat = findCat(5);
        if (cat != null) System.out.println(cat.getName());
        else System.out.println("there's no cat");

        //with optionals
        System.out.println("----------------------------------");
        Optional<Cat> optCat = findCat2(5);

        //orElse, returns the value if not null, or the default value passed
        Cat myCat = optCat.orElse(new Cat("default michi", 0));
        System.out.println("The michi was: " + myCat.toString());

        //orElseGet, use a lambda in order to supply the default value, which means, it performs an action
        myCat = findCat2(6).orElseGet(()->{
            System.out.println("performing tasks to create the cat");
            return new Cat("michi defalt", 0);
        });
        System.out.println("The cat with orElseGet was " + myCat);

        //orElseThrow, throw exception if the value is null
        try{ findCat2(5).orElseThrow();}
        catch(Exception e){
            System.out.println(e.toString());
        }

        //the map method
        int ageCat = findCat2(6).map(Cat::getAge).orElse(0);
        System.out.println("the age was "  + ageCat);


        //ifPresent, this receives a lambda which is the action to perform only if the optional is present
        //if we don't need the reference, but only an action to perform, this is the best
        findCat2(8).ifPresent((c)->{
            System.out.println("Hi you guys, my name is " + c.getName() + "!!!!!!!!!!");
        });

        //ifPresentOrElse takes two lambdas, the first is the case of presence, and the second is the case of null
        findCat2(9).ifPresentOrElse((c)-> System.out.println("Hi you guys, my name is " + c.getName() + "!!!!!!!!!!"),
                ()-> System.out.println("We didn't find the cat"));



        //optionals are only intended to use as return type, when the return value may be null, it enforces to handle that cas
    }


    private static Cat findCat(int n){
        if(n % 2 == 0) return new Cat("Marmol", 8);
        return null;
    }

    private static Optional<Cat> findCat2(int n){
        //.of is when we know the value is not null
        /*if(n % 2 == 0) return Optional.of(new Cat("Marmol", 8));
        return Optional.of(null);*/

        //or better
        //orNullable is when the value may be null
        Cat cat = null;
        if(n % 2 == 0) cat = new Cat("Marmol", 8);
        return Optional.ofNullable(cat);
    }
}
