package com.diegoBermudez.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CountDownLatch {
    public static void main(String[] args) throws InterruptedException{
        //Phaser is an utility which is like a cyclic barrier and a countdownlatch in one, I mean, is not exactly that
        //but it's a more flexible utility which can be used for do both of those things and more

        //AS A COUNTDOWNLATCH
        Phaser phaser = new Phaser(4);
        ExecutorService myPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            myPool.execute(new MyRun1(phaser));
            Thread.sleep(200);
        }
        System.out.println("///++++++++++I will wait until 5 of the 10 threads reach the point I want");
        phaser.awaitAdvance(1);
        System.out.println("///+++++++++++lready reacheddddddd, yeahhhhhhhhhhhhhhhhhhhhhhhhh");
        Thread.sleep(500);
        System.out.println("///+++++++++++Continuing with more workkk");
        myPool.shutdown();
    }
}
