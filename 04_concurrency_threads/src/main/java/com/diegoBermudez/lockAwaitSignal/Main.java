package com.diegoBermudez.lockAwaitSignal;

public class Main {
    public static void main(String[] args) {
        //await and signal are just like wait and notify but for locks,
        //we use conditions.
        //since it's almost the same, this example will be pretty basic
        CPU myCPU = new CPU();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    myCPU.turningOn();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        Thread t2 = new Thread(){
            @Override
            public void run(){
                try {
                    myCPU.gpuOn();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        t1.start();
        t2.start();

    }
}
