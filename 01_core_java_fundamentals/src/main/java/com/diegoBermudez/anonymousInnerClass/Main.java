package com.diegoBermudez.anonymousInnerClass;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Animal();
        dog.makeNoise();

        //when we only 1 instance of that class, only 1 existence

        //Anonymous subclass
        Animal bigfoot = new Animal(){
            @Override
            public void makeNoise(){
                System.out.println("jhskfhjsdhfjsfjs");
            }
        };
        bigfoot.makeNoise();


        //Implementing an interface
        Runnable  myAnonymousRunnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("I'm an anonymous runnable");
            }
        };
        myAnonymousRunnable.run();
    }
}
