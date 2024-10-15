package com.diegoBermudez.threads1;

//METHOD 2, IMPLEMENTING RUNNABLE
public class MultiThreading implements  Runnable{

    private final int threadNumber;
    public MultiThreading(int threadNumber){
        this.threadNumber  = threadNumber;
    }

    @Override
    public void run() {
        for(int i= 0; i < 5; i++){
            System.out.println(i+1 + "  " + this.threadNumber);
            if(threadNumber == 3) throw new RuntimeException();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
