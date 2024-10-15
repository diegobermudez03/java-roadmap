package com.diegoBermudez.syncWaitNotify;

import java.util.Scanner;

public class House2 implements IHouse{

    public synchronized void goToBathroom(){
        System.out.println("I just went to the bathroom in thread " + Thread.currentThread().getName());
        System.out.println("I must wait until the person outside changes clothes in order to getting out");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finally, I'm here, I was able to go out from the bathroom " + Thread.currentThread().getName());
    }

    public synchronized void changingClothes(){
        System.out.println("\nI'm changing my clothes in thread " + Thread.currentThread().getName());
        Scanner myScan = new Scanner(System.in);
        System.out.println("Tell me when you're done changing clothes with an enter");
        myScan.nextLine();
        this.notifyAll();
        System.out.println("I finished, and I already told the person in the bathroom that I finished, but " +
                "I'm still need to go out and close the door so he is sure");
        System.out.println("closes de door!!\n");
    }
}
