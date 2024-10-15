package com.diegoBermudez.semaphore;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SocialNetwork {

    private static List<User> activeUsers = new LinkedList<>();
    private Semaphore limitUsers = new Semaphore(4,true);
    private Object listLock = new Object();
    public SocialNetwork(){
    }

    public void login(User user){
        //here we use tryAcquire, this one won't block the flow, will try, and if it is not able, will continue with the
        //handling, but we can use only Acquire, in that case it will block until it's able to acquire the semaphore
        if(limitUsers.tryAcquire()) {
            synchronized (listLock) {
                activeUsers.add(user);
            }
            System.out.println("Succesfully login "+ user.getName() );
        }else{
            System.out.println("We are sorry " + user.getName() + " you weren't able to login");
        }
    }

    public void logout(User user){
        limitUsers.release();
        synchronized (listLock){
           if (activeUsers.remove(user)) System.out.println("Succesfully logout " + user.getName());
        }
    }

}
