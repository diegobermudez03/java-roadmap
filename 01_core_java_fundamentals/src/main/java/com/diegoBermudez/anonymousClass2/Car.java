package com.diegoBermudez.anonymousClass2;

public class Car {
    private  int km;
    private int model;

    public Car(int km, int model) {
        this.km = km;
        this.model = model;
    }

    public void modify( int km, int model){
        this.km = km;
        this.model = model;
    }

    @Override
    public String toString(){
        return "Year: " + model + "  KM: "  +km;
    }
}
