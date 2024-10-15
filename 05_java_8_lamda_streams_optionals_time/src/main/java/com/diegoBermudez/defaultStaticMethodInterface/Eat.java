package com.diegoBermudez.defaultStaticMethodInterface;

public interface Eat {

    default double digest(){
        double acid = Math.random() * 50;
        System.out.println("digesting the food, producing acid");
        return acid;
    }
}
