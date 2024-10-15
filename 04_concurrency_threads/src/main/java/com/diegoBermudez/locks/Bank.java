package com.diegoBermudez.locks;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Lock transactLock = new ReentrantLock(true); //so it's a fair locks, which means, it has a queue, and the next thread is the
    //one who has waited the most
    private Lock loginLock = new ReentrantLock(true);
    private List<Double> transacts = new LinkedList<>();

    public Bank(){
        for(int i = 0; i < 10; i++){
            transacts.add(200D);
        }
    }
    public void getCredit(double amount)  {
        System.out.println("So, you want to get some money money money, must be funny, in a real world");
        transactLock.lock();
        try {
            if (this.getCurrentAmount() < amount) {
                System.out.println("it seems you don't have enough money");
            } else {
                System.out.println("You have enough money, let the system login and then we'll make the transaction");
                if(login()) {
                    transacts.add(-amount);
                    System.out.println("you're new balance is of " + getCurrentAmount());
                }else{
                    System.out.println("we weren't able to login, sorry");
                }
            }
        } finally {
            transactLock.unlock();
        }
    }

    public double getCurrentAmount(){
        transactLock.lock(); //so that while we are retrieving, no one else modifies it
        try {
            double amount = 0.0D;
            for(Double d: transacts){
                amount += d;
            }
            return amount;
        }
        finally {
            transactLock.unlock();
        }
    }

    public boolean login() {
        //loginLock.lock();
        try {
            boolean locked = loginLock.tryLock(3, TimeUnit.SECONDS);
            if(locked) {
                System.out.println("Lets login into your account, lets imagine you gave me the credentials, wait a sec");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Login succesful, your balance is " + getCurrentAmount());
                loginLock.unlock();
                return true;
            }else{
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
