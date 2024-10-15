package com.diegoBermudez;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VarKeyword {

    //private var variable;     //doesn't work

    public static void main(String[] args) {
        //Local-variable type inferance (LVTI)

        //there are only 2  rules:
        // 1. that the type needs to be able to be infered in the declaration
        // 2. it only works in local scope, so only inside methods, not a class scope
        var myVar = 10;
        var myList = new LinkedList<String>();
        var array = new Integer[]{1,2,3};
        final var word = "hola como estas";
        var opt = Optional.of(new HashMap<Integer, List<String>>());
        var list1 = new LinkedList<String>();
        var list2 = new LinkedList<String>();
        list1.add("hola");
        list1.add("chao");
        list2.add("happy");
        list2.add("sad");
        opt.get().put(1, list1 );
        opt.get().put(2, list2);
        opt.get().forEach((key, val)-> {
            System.out.println(key);
            val.forEach(System.out::println);
        });
        //it must be used in to make the code more readable, so only use it when the type is really easy to infer
        //for instance when using the "new" kwyword, otherwise, is better to have the type written, for readability

        //the variable needs to be initialized to a value, non null, since it must know from the start the type
        //it needs to be able to infere it sice the first moment

        //var notNull = null;  //cannot do it
    }
}
