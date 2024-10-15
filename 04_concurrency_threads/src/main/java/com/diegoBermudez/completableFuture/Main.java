package com.diegoBermudez.completableFuture;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //just a few notes, every AYNC version of the method, means that that method will be xecuted in a new thread
        //whereas the not async methods will continue in the thread of the method chanied before
        //thenAccept and thenRun serve as the final step when we don't return nothing, thenRun doesn't have access to the
        //previously returned element
        //each apply method returns a CompletableFuture, we can receive it and then use the .get() method if we want that
        ExecutorService clientsPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 3; i++) {
            System.out.println("+++CLIENTE " +( i+1));

            CompletableFuture.supplyAsync(() -> {
                System.out.println("1.First we are logging in");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("1.Logged in succesfully, returning account");
                if((int)(Math.random() * 10) % 2 == 0) throw new RuntimeException();
                return new Account("Juan", 12000D);
            }, clientsPool).thenApplyAsync((account) -> {
                System.out.println("2.Just received the account from " + account.getName());
                System.out.println("2.Processing transaction");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("2.Transaction processed, new balance is " + (account.getBalance() - 100));
                account.setBalance(account.getBalance() - 100);
                return account;

            }, clientsPool).thenAccept((account) -> {
                System.out.println("3.So, lets save the information");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("3.Information stored, balance of " + account.getName() + " is " + account.getBalance());
            }).exceptionally((exception) -> {
                System.out.println("it seems an error ocurred, here it is " + exception.toString());
                return null;
            });
        }
        System.out.println("++++++Ya terminamos todos los clientes");
        clientsPool.awaitTermination(10, TimeUnit.SECONDS);

        //THERE ARE A LOT OF OTHER METHODS, BUT FOR NOW, I ONLY WANT TO SHOW THE THENCOMBINE, IT TAKES TWO COMPLEATABLE
        //AND RETURNS A RESULT WHICH USES THE FINAL RESULTS FROM BOTH COMPLETABLE FUTURES, THERE'S OTHER THAT'S CALLED
        //thenAcceptBoth that is similarly but this won't return something.
        //there's another that is called allOf, which takes many Completable futures

        CompletableFuture<Double> myComp1 = process1();
        CompletableFuture<Double> myComp2 = process2();
        CompletableFuture<Double> result = myComp1.thenCombine(myComp2, (result1, result2) -> {
            return result1 + result2;
        });
        System.out.println("The result is "+ result.get());
    }

    private static CompletableFuture<Double> process1(){
        return CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("returning from process 1");
            return 1000D;
        });
    }

    private static CompletableFuture<Double> process2(){
        return CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("returning from process 2");
            return 25000D;
        });
    }
}
