package com.diegoBermudez.defaultStaticMethodInterface;

public interface Walk {

    int numberHuman = 2;    //final static by default
    int numberAnimal = 4;   //final static by default

    void jump(int km);

    double prepare();

    default void starts(){
        System.out.println("Hi, I'm  going to walk");
    }
    default void stops(){
        System.out.println("I just stopped walking");
    }
    static int whatIsWalk(){
        System.out.println("Walk is the process of walking usually with " + numberHuman + " legs for humans and " + numberAnimal + " for animals");
        return (int)(Math.random() * 4);
    }
}
