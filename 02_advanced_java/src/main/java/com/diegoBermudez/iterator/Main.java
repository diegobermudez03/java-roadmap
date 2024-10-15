package com.diegoBermudez.iterator;

public class Main {
    public static void main(String[] args) {
        MyList numbers = new MyList();
        numbers.add(29);
        numbers.add(23);
        numbers.add(24);
        numbers.add(90);
        for (MyList it = numbers; it.hasNext(); ) {
            int i = (int)it.next();
            System.out.println(i);
        }
    }
}
