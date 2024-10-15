package com.diegoBermudez.enums;

public enum Cereals {
    CAPTAIN_CRUNCH(10, 15000),
    CHOKOCRISPIS(60,20000),
    TRIX(100,30000),
    FROOT_LOOPS(50,4000);

    final int levelOfDeliciousness;
    private final double price;

    Cereals(int level, double price){
        this.levelOfDeliciousness = level;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
