package com.diegoBermudez.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception{
        Human juan = new Human("juan");
        if(juan.getClass().isAnnotationPresent(Veryimportant.class)) System.out.println("it's very important");
        for(Annotation n : juan.getClass().getAnnotations()){
            System.out.println(n);
        }

        //check methods
        for(Method m: juan.getClass().getMethods()){
            if(m.isAnnotationPresent(RunInmediatly.class)){
                for(int i = 0; i < m.getAnnotation(RunInmediatly.class).times(); i++){
                    m.invoke(juan);
                }
            }
        }

        for(Field f: juan.getClass().getFields()){
            if (f.isAnnotationPresent(ImportantString.class)){
                f.setAccessible(true);
                if(f.get(juan) instanceof String s){
                    System.out.println(s);
                }
            }
        }
    }
}
