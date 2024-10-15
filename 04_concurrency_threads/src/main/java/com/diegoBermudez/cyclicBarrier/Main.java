package com.diegoBermudez.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //A cyclic barrier is like the contrary from a countdownlatch, this one allows
        //multiple threads to wait until a certain number are at some part of the code, when all of them
        //said "await", only until then, they are allowed to continue again, this would be useful if
        //we want to have like checkpoints in some parts to allow our threads to synchronize

        CyclicBarrier myBarrier = new CyclicBarrier(4);
        ExecutorService myPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 4; i++){
            myPool.execute(new MyRun(myBarrier));
        }
        myPool.shutdown();
        System.out.println("//////////////ENDED FROM THE MAIN");
    }
}
