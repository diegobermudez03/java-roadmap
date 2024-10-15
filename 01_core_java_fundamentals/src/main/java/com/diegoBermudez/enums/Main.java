package com.diegoBermudez.enums;

public class Main {
    public static void main(String[] args) {
        DaysOfTheWeek day = DaysOfTheWeek.SATURDAY;

        if(day == DaysOfTheWeek.SATURDAY) System.out.println("It's almost friday");

        for(DaysOfTheWeek d: DaysOfTheWeek.values()){
            System.out.println(d);
        }

        Cereals cer = Cereals.TRIX;
        System.out.println(cer.levelOfDeliciousness + " and price: $" + cer.getPrice());

        switch(cer){
            case CAPTAIN_CRUNCH:
                System.out.println("it's captian crunch");
                break;
            case TRIX:
                System.out.println("it's trix");
                break;
            default:
                System.out.println("its neither");
                break;
        }
    }
}
