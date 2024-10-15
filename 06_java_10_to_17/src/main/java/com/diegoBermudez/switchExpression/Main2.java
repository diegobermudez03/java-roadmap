package com.diegoBermudez.switchExpression;

public class Main2 {
    public static void main(String[] args) {

    }

    /*
    private static double asDouble(Object o){
        //this is not supported at jdk 17, is more modern, is similar to the dart one
        return switch(o){
            case Double n -> n;
            case Number n -> n.doubleValue();
            case Integer n -> n.doubleValue();
            case Number n -> n.doubleValue();
            case String n-> Double.parseDouble(n);
            case null -> 0.0;
            default -> 0.0;
        }
    }*/
}
