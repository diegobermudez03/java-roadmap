package com.diegoBermudez.syncWaitNotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //First example, check how, we must be careful with the logic, because with this logic, the last thread, Thread-3
        //will be left waiting for another thread to notify, but there are no more threads that notify, so the program will
        //just never end, since we have an user thread alive waiting, the sleep is only to assure the order of the threads
        House myHouse = new House();
        MyThread t1 = new MyThread(myHouse, 2);
        MyThread t2 = new MyThread(myHouse, 1);
        MyThread t3 = new MyThread(myHouse, 2);
        t1.start();
        Thread.sleep(10);
        t2.start();
        Thread.sleep(10);
        t1.join();
        t2.join();
        t3.start();
        Thread.sleep(1000);
        t3.stop(); //DEPRECATED, SHOULDN'T USE IT, IS ONLY TO SHOW THE NEXT EXAMPLE

        System.out.println("------------------------------------------");
        //Now lets check why we would need a notifyAll instead of just a notify in some cases, it depends on the logic
        t1 = new MyThread(myHouse, 2);
        t1.setName("ex2_1");
        t2 =  new MyThread(myHouse, 2);
        t2.setName("ex2_2");
        t3 = new MyThread(myHouse, 1);
        t3.setName("ex2_3");
        t1.start();
        t2.start();
        Thread.sleep(10);
        t3.start();
        t1.join();
        t3.join();
        Thread.sleep(1000);
        t2.stop(); //DEPRECATED, SHOULDN'T USE IT, IS ONLY TO SHOW THE NEXT EXAMPLE

        System.out.println("------------------------------------------");
        //In this example there's a thread left waiting for a notification, but no one will notify him

        //WITH NOTIFY ALL
        House2 myHouse2 = new House2();
        t1 = new MyThread(myHouse2, 2);
        t1.setName("ex3_1");
        t2 =  new MyThread(myHouse2, 2);
        t2.setName("ex3_2");
        t3 = new MyThread(myHouse2, 1);
        t3.setName("ex3_3");
        t1.start();
        t2.start();
        Thread.sleep(10);
        t3.start();
    }
}
