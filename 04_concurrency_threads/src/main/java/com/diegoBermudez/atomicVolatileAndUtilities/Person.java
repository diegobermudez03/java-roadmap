package com.diegoBermudez.atomicVolatileAndUtilities;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Person {

    private AtomicBoolean married = new AtomicBoolean();
    private AtomicInteger age = new AtomicInteger();
    private AtomicReference<Dog> pet = new AtomicReference<>();

    public void setPet(){
        pet.set(new Dog("lufus", 10));
    }

    public  void changeAge(){
       this.age.incrementAndGet();
    }

    public int getAge(){
        return age.get();
    }
}
