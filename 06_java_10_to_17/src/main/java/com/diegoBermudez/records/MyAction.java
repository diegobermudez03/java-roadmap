package com.diegoBermudez.records;

public interface MyAction {

    default void action(){
        System.out.println("the action");
    }
    void overrideMe();
}
