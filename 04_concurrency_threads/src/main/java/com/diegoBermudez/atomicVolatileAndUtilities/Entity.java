package com.diegoBermudez.atomicVolatileAndUtilities;

public  class Entity {
    private volatile boolean allowContinue = false;

    public void changePermission() throws InterruptedException {
        System.out.println("I'm in, I'll try to change the permission");
        Thread.sleep(5000);
        allowContinue = true;
        System.out.println("Permission changed");
    }

    public void accessPermission() throws InterruptedException {
        while(!allowContinue){
            System.out.println("I'll try to get out");
            Thread.sleep(1000);
        }
    }
}

