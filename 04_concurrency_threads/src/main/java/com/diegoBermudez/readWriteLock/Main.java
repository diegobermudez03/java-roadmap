package com.diegoBermudez.readWriteLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Airplane air = new Airplane();
        MySeatsThread t1 = new MySeatsThread(15, air);
        MySeatsThread t2 = new MySeatsThread(23, air);
        t1.start();
        t2.start();
        t1.join();
        t2.join();


        MySeatsThread t3 = new MySeatsThread(10, air);
        MySeatsThread t4 = new MySeatsThread(22, air);
        t3.start();
        for(int i = 0; i < 5; i++){
            (new MyReadThread(air)).start();
            Thread.sleep(100);
        }
        t4.start();
        for(int i = 0; i < 5; i++){
            (new MyReadThread(air)).start();
            Thread.sleep(100);
        }
    }
}
