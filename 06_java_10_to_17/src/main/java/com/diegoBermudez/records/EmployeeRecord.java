package com.diegoBermudez.records;


//records CAN'T extends any class, since by default they already extends the record class
//records CAN'T be extended. they are final by default
public record EmployeeRecord(String name, int employeeNumber) implements  MyAction{

    //the fields are final, all the instance fields will be private with getters with the same name as the fields
    //all the instance fields (non static ones) must be declared upside in the record declaration

    /*this is to show that we can override the constructor that's created by default, but even this is to much
    we can use compact constructor as the one below
     public EmployeeRecord(String name, int employeeNumber){
        if(employeeNumber<0){
            throw new IllegalArgumentException("employee number must be > 0");
        }
        this.name = name;
        this.employeeNumber = employeeNumber;
    }*/

    //compact constructor: recall that the record creates a constructor by default, this is if we want to customize it, but
    //the compact constructor by default receives the fields parameters, and at the end sets them
    public EmployeeRecord{
        if(employeeNumber<0){
            throw new IllegalArgumentException("employee number must be > 0");
        }
    }

    //DEFAULT CONSTRUCTOR: we can have also multiple constructor as in classes, if it's a custom one, it must call a canonical one
    public EmployeeRecord(){
        this("NO name", 0);
    }


    public static int recordVar= 50;

    public String nameInUpper(){
        return this.name.toUpperCase();
    }

    public void doSomething(){
        System.out.println("heloooooo");
    }

    @Override
    public void overrideMe() {
        System.out.println("overriden");
    }
}
