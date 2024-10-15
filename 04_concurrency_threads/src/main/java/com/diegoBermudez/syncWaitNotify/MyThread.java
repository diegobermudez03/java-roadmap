package com.diegoBermudez.syncWaitNotify;

public class MyThread extends Thread{

    private IHouse house;
    private int number;
    public MyThread(IHouse house, int number){
        this.house = house;
        this.number = number;
    }

    public void run(){
        if (this.number % 2 == 0) {
            house.goToBathroom();
        } else {
            house.changingClothes();
        }
    }
}
