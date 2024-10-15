package com.diegoBermudez.atomicVolatileAndUtilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //I tried to show a case when the volatile word is needed, but I don't know why it works perfectly without it haha
        //however just for you to know, the volatile keyword is used so that the threads now that they always need to
        //read the original variable, and not to store in cache a version of it, so they always read the last update
        //it works with values, if we have a reference type and its final, it doesn't matter, we can avoid the volatiñle
        //only use the volatile when needed, it affects efficiency
        Entity entity = new Entity();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    entity.changePermission();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    entity.accessPermission();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t2.join();

        //Atomic variables
        //atomic variables are concurrent utilities to use like when we want to perform concurrent operations on
        //primitive types, is preferred to use atomic variables instead of locks for each operation
        Person juan = new Person();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 500; i++) pool.execute(new Runnable() {
            @Override
            public void run() {
                juan.changeAge();
                juan.setPet();
            }
        });
        Thread.sleep(1000);
        System.out.println("the final age is " + juan.getAge());

        //There are a lot more of utilities like

        LongAdder adder = new LongAdder(); //mantains a set of the numbers, it calculates the result when we want
        //to get it, but internally mantains all the different values added

        //LongAccumulator acumulador = new LongAccumulator();
        //and many more

    }
}
