package com.diegoBermudez.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyRun implements Runnable{

    private CountDownLatch counter;
    private final int ID = (int) (Math.random() * 100);

    public  MyRun(CountDownLatch counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        try {
            System.out.println("Hi, I'm performing some action from thread " + ID);
            Thread.sleep(2000);
            System.out.println("-----------From thread " + ID + " I'm ready");
            counter.countDown();
            Thread.sleep(2000);
            System.out.println("************Finallly I'm done from thread " + ID);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
