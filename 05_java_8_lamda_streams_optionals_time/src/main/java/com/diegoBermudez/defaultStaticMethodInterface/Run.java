package com.diegoBermudez.defaultStaticMethodInterface;

public interface Run {

    default void starts(){
        System.out.println("starting to run");
    }

    default void stops(){
        System.out.println("it was enough running");
    }

}
