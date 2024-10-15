package com.diegoBermudez.threads2;

import com.diegoBermudez.threads1.MultiThread;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args)  {
        System.out.println(Thread.activeCount());
        Thread.currentThread().setName("myMainThread");
        System.out.println(Thread.currentThread().getName());

        //PRIORITY
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());

        //CHECK IF IT'S ALIVE
        System.out.println(Thread.currentThread().isAlive());

        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        //my code
        MultiThread t1 = new MultiThread(10);
        t1.start();
        System.out.println("--------------" + t1.isAlive() + "  " + t1.getPriority()) ;
        t1.setPriority(3);
        System.out.println("active count " + Thread.activeCount());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("++++++++++++++" + t1.isAlive() + "  " + t1.getPriority());

        //DAEMON THRAD: ARE LIKE THE ONES WORKING IN THE BACKGROUND OF JVM, LIKE GARBAGE COLLECTIOM
        //USER THREADS: ARE THE ONES WE CREATE INCLUDING THE MAIN, WHEN ALL THESE TERMINATE, THEN THE PROGRAM TERMINATES

        //Example Daemon
        MultiThread t2 = new MultiThread(10);
        t2.setDaemon(true);
        t2.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main finishing, lets see if the program ends since t2, even tough is still running, is daemon");



        //join method
        System.out.println("********************** JOIN METHOD");
        MultiThread th1 = new MultiThread(16);
        MultiThread th2 = new MultiThread(17);
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Only until now, that both threads are finished, I will continue");

        //example with conditions
        System.out.println("********************** JOIN METHOD 2");
        th1 = new MultiThread(18);
        th2 = new MultiThread(19);
        th1.start();
        th2.start();
        int random = (int)(random() * 10);
        System.out.println("random is " + random);
        if( random % 2 == 0) {
            try {
                System.out.println("I decided, I will wait");
                th1.join();
                th2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("hello from the other side");

        //IMPLEMENTING THREAD WITH RUNNABLE, BUT THIS TIME, USING ANONYMOUS CLASS

        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from the thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("goodbye from the thread");
            }
        };
        Thread myThread = new Thread(myRun);
        myThread.start();
        System.out.println("the end is here");
    }
}
