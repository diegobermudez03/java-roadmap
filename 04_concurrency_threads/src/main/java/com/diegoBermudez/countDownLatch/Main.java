package com.diegoBermudez.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //A countdownlatch is like a counter which allows us to do some kind of join of various threads in certain thread
        //but, different than join, which waits until those threads end their execution, with countdownlatch we can choose
        //exactly when we want to continue, which means, the other threads tell us when they are ready, in reality they discount the
        //countdownlatch

        CountDownLatch myCount = new CountDownLatch(5);
        ExecutorService myPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            myPool.execute(new MyRun(myCount));
            Thread.sleep(200);
        }
        System.out.println("///++++++++++I will wait until 5 of the 10 threads reach the point I want");
        myCount.await();
        System.out.println("///+++++++++++lready reacheddddddd, yeahhhhhhhhhhhhhhhhhhhhhhhhh");
        Thread.sleep(500);
        System.out.println("///+++++++++++Continuing with more workkk");
        myPool.shutdown();

    }
}
