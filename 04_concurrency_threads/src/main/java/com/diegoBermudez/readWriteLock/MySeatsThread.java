package com.diegoBermudez.readWriteLock;

public class MySeatsThread extends Thread{
    private int number;
    private Airplane air;

    public  MySeatsThread(int number, Airplane air){
        this.number = number;
        this.air = air;
    }

    @Override
    public void run(){
        air.addSeat(number);
    }

}
