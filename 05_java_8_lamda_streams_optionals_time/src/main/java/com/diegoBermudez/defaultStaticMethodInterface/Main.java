package com.diegoBermudez.defaultStaticMethodInterface;

public class Main {
    public static void main(String[] args) {

        //static methods in interfaces are just that, static methods, that can be called from the interface
        Walk.whatIsWalk();
        System.out.println("checking legs: " + Walk.numberAnimal);

        Person p = new Person("juan diego", 20);
        Atlhet a = new Atlhet("Messi", 40);

        System.out.println("JUAN DIEGO:");
        System.out.println("Heart beat: " + p.prepare());
        p.starts();
        p.jump(20);
        p.myThing();
        System.out.println("acid: " +p.digest());

        System.out.println("\nMESSI: ");
        System.out.println("Heart beat: " + a.prepare());
        a.starts();
        a.jump(80);
        a.stops();
        System.out.println("acid: " +a.digest());

        //so, default methods are like mixins, allows us some kind of multiple inheritance, not only
        //a contract of what we have to do, but actually providing the implementation, it can also have the diamond
        //problem, in which case we have to implement that method in the class implementing the interfaces
        //the idea is to leave abstract classes for inheritance when the relation is that, of direct inheritance
        //like Human, Pilot, etc, and letting the interfaces with default methods for like capabilites that are shared
        //by different entities, or if there's a case of multiple inheritance, use the abstract class for the main
        //inheritance relationship, and the interface for the secondary, Car extends Vehicle, and implements Motorized


    }
}
