package com.diegoBermudez.syncThreads;

public class MultiThread extends Thread{
    protected SharedElement myShared;

    public MultiThread(SharedElement myShared){
        this.myShared = myShared;
    }

    @Override
    public void run(){
        for(int i = 0; i < 1000000; i++) {
            myShared.increaseSync();
        }
    }
}
