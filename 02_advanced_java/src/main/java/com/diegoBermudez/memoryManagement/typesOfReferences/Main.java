package com.diegoBermudez.memoryManagement.typesOfReferences;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        //there are 4 reference types, strong references, weak references, soft references and phantom references,
        //STRONG REFERENCES: the normal ones, the ones we always use

        //WEAK REFERENCES : This references an object, but the object has to be referenced by a strong referenced to still exist
        //otherwise the garbage collector will collect it

        //SOFT REFERENCES: Ideal for cache, it keeps alive the object, but if the application runs out of memory, it's allowed
        //to collect these references, so we use them like for cache, when it's nice to have that info stored, but not mandatory

        //WEAK REFERENCE
        List<Integer> myNumbers = new LinkedList<>();
        WeakReference<List<Integer>> myWeakReference = new WeakReference<>(myNumbers);
        for(int i =0; i < 5; i++) myNumbers.add(i);

        if(myWeakReference.get() != null){
            for(Integer i: myWeakReference.get()){
                System.out.println("in the weak reference " + i);
            }
        }
        //liberating the strong reference
        myNumbers = null;
        System.gc();    //to garbage collect wight now
        if(myWeakReference.get() == null) System.out.println("\nNow the weak reference is empty");


        //SOFT REFERENCE: I cant replicate the event when the JVM needs to liberate memory, so I can't show that part
        System.out.println("----------------------------------");
        SoftReference<List<Integer>> softRef = new SoftReference<>(new LinkedList<>());
        softRef.get().add(21);
        softRef.get().add(22);
        softRef.get().add(23);
        for(Integer i: softRef.get()) System.out.println(i);


        //There are other weak or soft utilities, one interesting is WeakHashMap<>, it stores the keys as
        //weak references, so whenever the key is not referenced by another strong reference, the key and its value
        //in the map is also removed, it's ideally so that we don't have to manually remove the item from the hashmap
        Map<Cellphone, Double> cellphonesPrices = new WeakHashMap<>();
        Cellphone c1 = new Cellphone(2011, "xiaomi");
        Cellphone c2 = new Cellphone(2014, "xiaomi");
        System.out.println("Just to prove something");
        if(c1.getBrand() == c2.getBrand()) System.out.println("yes, the strings are the same");
        Cellphone c3 = new Cellphone(2020, "Motorola");
        Cellphone c4 = new Cellphone(2024, "Samsung");
        cellphonesPrices.put(c1, 14000D);
        cellphonesPrices.put(c2, 85000D);
        cellphonesPrices.put(c3, 14000D);
        cellphonesPrices.put(c4, 63000D);
        cellphonesPrices.forEach((key, value)->{
            System.out.println("the cellphone " + key.getBrand() + " costs $" + value);
        });
        System.out.println("++++++++++time to clean");
        c1 = null;
        c3 = null;
        System.gc();
        cellphonesPrices.forEach((key, value)->{
            System.out.println("the cellphone " + key.getBrand() + " costs $" + value);
        });


    }
}
