package com.diegoBermudez.generics;

import java.util.Collection;

public class Printer <T extends Vivid & Animal, V extends Collection>{
    T value;
    public Printer(T value, V coll){
        if(coll.getClass().getName().toLowerCase().contains("list")) System.out.println("is a list");
        this.value = value;
    }

    public void print(){
        value.makeSoung();
        value.sleep();
        value.born();
    }

}
