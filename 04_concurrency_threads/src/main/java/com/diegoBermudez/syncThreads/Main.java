package com.diegoBermudez.syncThreads;

public class Main {
    public static void main(String[] args) {
        //ASYNCHRONIZED
        SharedElement shared = new SharedElement();
        MultiThread myThread1 = new MultiThread(shared){
            @Override
            public void run(){
                for(int i = 0; i < 1000000; i++) {
                    myShared.increaseAsync();
                }
            }
        };
        Thread myThread2 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 1000000; i++) {
                    shared.increaseAsync();
                }
            }
        };
        Runnable myRunFor3 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000; i++) {
                    shared.increaseAsync();
                }
            }
        };
        Thread myThread3 = new Thread(myRunFor3);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        try {
            myThread1.join();
            myThread2.join();
            myThread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+++++++++++++++++++++++ COUNT ASYNCCCC ES " + shared.getCount());
        //SYNCHRONIZED
        shared.setZero();
        Thread myThread4= new MultiThread(shared);
        Thread myThread5 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 1000000; i++) {
                    shared.increaseSync();
                }
            }
        };
        Runnable myRunFor32 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000; i++) {
                    shared.increaseSync();
                }
            }
        };
        Thread myThread6 = new Thread(myRunFor32);
        myThread4.start();
        myThread5.start();
        myThread6.start();
        try {
            myThread4.join();
            myThread5.join();
            myThread6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+++++++++++++++++++++++ COUNT SYNC ES " + shared.getCount());

    }
}
