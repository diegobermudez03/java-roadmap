package com.diegoBermudez.iterator;

import java.util.Iterator;
import java.util.function.Consumer;


//ListIterator is a more specific subinterface of Iterator which has more methods for lists
//But for this example I won't use that one
public class MyList implements Iterator {
    private int[] numbers = new int[10];
    private int size = 0;
    private int index = 0;
    public MyList(){}

    @Override
    public boolean hasNext() {
        return index < (size - 1) ;
    }

    @Override
    public Object next() {
        return numbers[++index];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    public void add(int number){
        if(size == numbers.length){
            int[] aux = new int[numbers.length * 2];
            for(int i = 0; i < numbers.length; i++){
                aux[i] = numbers[i];
            }
            numbers = aux;
        }
        numbers[size] = number;
        size++;
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
