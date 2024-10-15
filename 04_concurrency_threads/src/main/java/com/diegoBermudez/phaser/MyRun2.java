package com.diegoBermudez.phaser;
import java.util.concurrent.Phaser;

public class MyRun2 implements Runnable{

    private final Phaser phase;
    private final int milis = (int)(Math.random() * 10000);
    private final int ID = (int)(Math.random() * 100);

    public MyRun2(Phaser phase){
        this.phase = phase;
    }

    @Override
    public void run() {
        try {
            System.out.println("From thread " + ID + " started");
            Thread.sleep(milis);
            System.out.println("From thread " + ID + " already ready to wait");
            phase.arriveAndAwaitAdvance();
            System.out.println("we are all here, ready to continue");
            Thread.sleep(milis);
            System.out.println("Thread " + ID + " gonna wait again");
            phase.arriveAndAwaitAdvance();
            System.out.println("AWESOME, WE ARE ALL HERE ONCE AGAIN, LETS FINISH THIS");
            Thread.sleep(milis);
            System.out.println("finished from thread " + ID);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

    }
}