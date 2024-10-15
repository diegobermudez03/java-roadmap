package com.diegoBermudez.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRun implements Runnable{

    private final CyclicBarrier barrier;
    private final int milis = (int)(Math.random() * 10000);
    private final int ID = (int)(Math.random() * 100);

    public MyRun(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("From thread " + ID + " started");
            Thread.sleep(milis);
            System.out.println("From thread " + ID + " already ready to wait");
            barrier.await();
            System.out.println("we are all here, ready to continue");
            Thread.sleep(milis);
            System.out.println("Thread " + ID + " gonna wait again");
            barrier.await();
            System.out.println("AWESOME, WE ARE ALL HERE ONCE AGAIN, LETS FINISH THIS");
            Thread.sleep(milis);
            System.out.println("finished from thread " + ID);
        }catch (InterruptedException | BrokenBarrierException e){
            throw new RuntimeException();
        }

    }
}
