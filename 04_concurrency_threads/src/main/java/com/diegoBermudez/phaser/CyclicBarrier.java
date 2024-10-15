package com.diegoBermudez.phaser;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CyclicBarrier {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(4);
        ExecutorService myPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 4; i++){
            myPool.execute(new MyRun2(phaser));
        }
        //the key point is the flexiblility, check how with phaser we can dinamically add more registered threads
        //and deregister them, we aren't limited to the number set first.
        (new Thread(){
            @Override
            public void run(){
                System.out.println("I'm the new kid who wants to register");
                phaser.register();
                System.out.println("Already registered, will wait");
                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Now I'll leave you continue");
                //phaser.arriveAndAwaitAdvance(); this is if we want to continue being registered
                phaser.arriveAndDeregister();
                System.out.println("That was fun enough, I won't continue playing");
            }
        }).start();
        myPool.shutdown();
        System.out.println("//////////////ENDED FROM THE MAIN");
    }
}
