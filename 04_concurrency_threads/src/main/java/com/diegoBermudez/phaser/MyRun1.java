package com.diegoBermudez.phaser;

import java.util.concurrent.Phaser;

public class MyRun1 implements Runnable{

    private Phaser phaser;
    private final int ID = (int) (Math.random() * 100);

    public MyRun1(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run(){
        try {
            System.out.println("Hi, I'm performing some action from thread " + ID);
            Thread.sleep(2000);
            System.out.println("-----------From thread " + ID + " I'm ready");
            phaser.arrive();
            Thread.sleep(2000);
            System.out.println("************Finallly I'm done from thread " + ID);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
