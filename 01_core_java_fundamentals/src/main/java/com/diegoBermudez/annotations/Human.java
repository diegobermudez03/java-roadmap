package com.diegoBermudez.annotations;

@Veryimportant
public class Human {

    @ImportantString
    public String name;

    public Human(String name){
        this.name = name;
    }

    @RunInmediatly(times = 2)
    public void hello(){
        System.out.println("hello");
    }
    public void goodBye(){
        System.out.println("goodbye");
    }
    @RunInmediatly(times = 3)
    public void count(){
        System.out.println("1,2,3.4");
    }
}
