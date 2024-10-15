package com.diegoBermudez.callableFuture;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //BASIC FUTURES
        //jUST AS A SIDE NOTE, WE CAN CANCEL FUTURES, SO IF WE DECIDE THAT IT HAS PASSED
        //MUCH TIME, WE CAN USE THE CANCEL METHOD, AND WE CAN SPECIFY IF WE WANT TO CANCEL IT
        //EVEN IF IT'S RUNNING
        Account myAccount = new Account(100);
        ExecutorService t1 = Executors.newSingleThreadExecutor();
        Future<Account.Result> balance = t1.submit(myAccount);
        System.out.println("waiting for the result, lets do something else mean while");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Still waiting");
        try {
            Account.Result finalBalance = balance.get(2100, TimeUnit.MILLISECONDS);
            System.out.println("the calculated balance was of " + finalBalance.balance);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("It seems the calculation wasn't fast enough");
        }
        t1.shutdown();


        //NOW USING INVOKE ALL OR ANY, TO INVOKE MANY FUTURES AT A TIME
        System.out.println("-----------------------------------------");
        List<Account> accounts = new LinkedList<>();
        for(int i = 0; i < 10; i++) accounts.add(new Account(i+1));
        ExecutorService futuresPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()-1);
        try {
            List<Future<Account.Result>> results = futuresPool.invokeAll(accounts);
            for(Future<Account.Result> future : results){
                if(!future.isDone()) System.out.println("we are waiting for a future");
                try {
                    Account.Result res = future.get();
                    System.out.println("ACCOUNT #" + res.number + " balance is $" + res.balance);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        futuresPool.shutdown();

        //INVOKE ANY, I WON'T ADD AN EXAMPLE BECAUSE IS PRETTY EASY, IT RECEIVES A COLLECTION OF TASKS
        //AND ONLY RETURNS THE VALUE OF THE ONE THAT FINISHED FIRST, THEN IT TRIES TO CANCEL THE OTHER ONES
        //IF THEY ARE STILL RUNNING OR HAVEN'T EVEN STARTED
    }
}
