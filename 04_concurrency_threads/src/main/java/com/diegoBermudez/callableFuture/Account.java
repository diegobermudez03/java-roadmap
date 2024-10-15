package com.diegoBermudez.callableFuture;

import java.util.concurrent.Callable;

public class Account implements Callable<Account.Result> {
    public class Result{
        public double balance;
        public int number;

        public Result(int number, double balance) {
            this.number = number;
            this.balance = balance;
        }
    }

    private int number;
    public Account(int number){
        this.number = number;
    }

    @Override
    public Result call() throws Exception {
        System.out.println("calculating the total");
        Thread.sleep(2500);
        return new Result(number, Math.random() * 100);
    }
}
