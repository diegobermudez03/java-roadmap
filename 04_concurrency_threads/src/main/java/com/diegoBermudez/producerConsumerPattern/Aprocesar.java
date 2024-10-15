package com.diegoBermudez.producerConsumerPattern;

public class Aprocesar {
    private int n;
    private String value;
    public static int counter = 0;

    public  Aprocesar(int n, String value){
        this.n = n;
        this.value = value;
    }

    @Override
    public String toString(){
        return "I was just consumed, I'm " + n + " " + value;
    }
}
