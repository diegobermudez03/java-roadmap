package com.diegoBermudez.lambda;

public class Car {

    private int model;
    private String brand;

    public Car(int model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public void carRun(){
        System.out.println("Lets run from the car " + brand);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("I ran really fast");
    }

    public int myMethod(double p1, double p2){
        System.out.println("from the car, check that I'm in the instance of " + brand);
        System.out.println("running the method with params " + p1 + " " + p2 );
        return 500;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString(){
        return "car " + brand + " from " + model;
    }
}
