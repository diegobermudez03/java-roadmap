package com.diegoBermudez.threads1;

//METHOD 1, EXTENDING THREAD CLASS
public class MultiThread extends Thread{

    private final int threadNumber;
    public MultiThread(int threadNumber){
        this.threadNumber  = threadNumber;
        this.setPriority(8);
    }

    @Override
    public void run(){
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

    public int getThreadNumber(){
        return this.threadNumber;
    }
}
