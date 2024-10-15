package com.diegoBermudez.forkJoinPool;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {

    private static int number = 0;
    private int numb;

    public MyRecursiveTask(){
        this.numb = ++number;

    }
    @Override
    protected Double compute() {
        if(number < 50) {
            System.out.println("lets call my parents from " + this.numb);
            MyRecursiveTask parent1 = new MyRecursiveTask();
            MyRecursiveTask parent2 = new MyRecursiveTask();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            parent1.fork();
            parent2.fork();
            return parent2.join() + parent1.join();
        }
        else {
            return 1D;
        }
    }
}
