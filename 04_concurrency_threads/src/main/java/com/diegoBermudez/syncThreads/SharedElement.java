package com.diegoBermudez.syncThreads;

public class SharedElement {
    private int count = 0;

    //we use "synchronized" to indicate that only 1 thread at a time can access the method
    public synchronized void increaseSync(){
        count++;
    }
    public void increaseAsync(){
        count++;

    }
    public int getCount(){
        return this.count;
    }

    public void setZero() {
        this.count = 0;
    }
}
