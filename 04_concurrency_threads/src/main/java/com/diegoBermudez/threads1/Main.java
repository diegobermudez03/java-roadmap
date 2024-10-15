package com.diegoBermudez.threads1;

public class Main {

    public static void main(String[] args) {

        //METHOD 1, EXTENDING THREAD CLASS
        for(int i = 0; i < 5; i++){
            MultiThread myThing = new MultiThread(i+1);
            myThing.start();
        }
        //throw new RuntimeException();
        //Stops the execution of the main thread until this specific thread finishes,
        //However the other threads are still going
        MultiThread joinTest = new MultiThread(50);
        joinTest.start();
        try {
            joinTest.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //METHOD 2, IMPLEMENTING RUNNABLE
        for(int i = 5; i < 10; i++){
            MultiThreading myThing = new MultiThreading(i+1);
            Thread myThread = new Thread(myThing);
            myThread.start();
        }
    }
}
