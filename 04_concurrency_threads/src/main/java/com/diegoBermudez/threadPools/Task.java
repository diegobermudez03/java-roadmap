package com.diegoBermudez.threadPools;

public class Task implements Runnable{
    private int number;

    public  Task(int number){this.number = number;}

    @Override
    public void run() {
        System.out.println("PROCESSING " + number);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SUCCESFULY PROCESSES " + number);
    }
}
