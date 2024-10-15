package com.diegoBermudez.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //a semaphore is like a lock, but this one allows multiple threads at once
        //we use it to limit the number of threads we want to have active, lets say
        //users in a social network
        List<User> usuarios = new ArrayList<>(7);
        usuarios.add(new User("juan", 20));
        usuarios.add(new User("gabriela", 19));
        usuarios.add(new User("augusto", 20));
        usuarios.add(new User("leonardo", 52));
        usuarios.add(new User("andres", 25));
        usuarios.add(new User("magnolia", 50));

        SocialNetwork network =  new SocialNetwork();
        ExecutorService myPool = Executors.newFixedThreadPool(6);
        for(User u: usuarios){
            myPool.execute(new Runnable() {
                @Override
                public void run() {
                    network.login(u);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    network.logout(u);
                }
            });
            Thread.sleep(200);
        }
        myPool.shutdown();
    }
}
