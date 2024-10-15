package com.diegoBermudez.readWriteLock;

public class MyReadThread extends Thread{
    private Airplane air;
    public MyReadThread(Airplane air){
        this.air = air;
    }

    @Override
    public void run(){
        air.readTotalSeats();
    }



}
