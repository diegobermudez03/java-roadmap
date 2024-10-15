package com.diegoBermudez.locks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Locks have some advantages from sync blocks, we'll explore them
        //here

        //the following is an example of a deadlock, if you first login, mand then , in the 5 seconds after
        //you get a credit, that will cause a deadlock if we are only using .lock, since login requires the transactions
        //lock, and the transaction has it, and it needs the loginlock, which the login has
        //but if we change the lock to trylock, we can avoid the deadlock
        Bank myBank = new Bank();
        System.out.println("The options are\n1. Login\n2.Get credit\n3.Break");
        Scanner myScan = new Scanner(System.in);
        int opt;
        while(true){
            opt = myScan.nextInt();
            switch (opt){
                case 1:
                    (new Thread(){
                        @Override
                        public void run(){
                            myBank.login();
                        }
                    }).start(); break;
                case 2:{
                    System.out.println("Introduce the amount");
                    double amount = myScan.nextDouble();
                    (new Thread(){
                        @Override
                        public void run(){
                            myBank.getCredit(amount);
                        }
                    }).start();
                }
            }
            if(opt == 3) break;
        }
    }
}
