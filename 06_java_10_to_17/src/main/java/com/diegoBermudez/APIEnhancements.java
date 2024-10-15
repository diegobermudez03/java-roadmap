package com.diegoBermudez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIEnhancements {
    public static void main(String[] args) {
        //these are some of the enhacements included to API's in the jdk 10 and later
        //some of them have alreayd been showed in their sections, so here I'll only shows the not shown ones

        //collections:
        //there were added the factory method creators for collections, THESE COLLECTIONS ARE INMUTABLE
        List<String> lista = List.of("hola", "como", "estas", "tu");
        //lista.add("chao");    //cant do it
        lista.forEach(System.out::println);

        System.out.println("------------------------------------------");
        List<String> palabras = new ArrayList<>(List.of("hola", "como", "estas", "tu"));
        palabras.add("chao");
        palabras.forEach(System.out::println);

        Map<String, Integer> ages = Map.of("Juan Diego", 20, "Gabriela", 19);
        ages.forEach((k, v)-> System.out.println("Name: " + k + " age: " + v));


        System.out.println("------------------------------------------");
        //copy methods
        List<String> nuevas = List.copyOf(palabras);    //it's inmutable
        nuevas.forEach(System.out::println);


        System.out.println("------------------------------------------");
        //Stream toList method, simplifies the collector  JDK 16
        List<Integer> numerosAntes = Stream.of(12, 60, 50, 10, 30,12, 50).distinct().collect(Collectors.toList());
        List<Integer> numerosNuevo = Stream.of(12, 60, 50, 10, 30,12, 50).distinct().toList();
        numerosNuevo.forEach(System.out::println);


        System.out.println("------------------------------------------");
        //List to array JDK 11
        String[] arrPalabras = palabras.toArray(String[]::new);
        for (String p : arrPalabras) {
            System.out.println(p);
        }


        //Streams:
        //the methods takeWhile and dropWhile were added, there are already examples of those in that section

        //Optionals:
        //ifPresentOrElse
        //stream
        System.out.println("------------------------------------------");
        Optional.of("HOLA").stream().toList().forEach(System.out::println);



        System.out.println("------------------------------------------");
        //Arrays, this is not even modern, this is from 1.2, but I wanted to include examples of this
        Arrays.stream(new int[]{1,2,3,4,1,2,3,4}).distinct().forEach(System.out::println);
        List<String> words = Arrays.asList("uno", "dos", "tres", "cuatro"); //returns an ArrayList
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5,6}));

        //also not new, but wanted to show, we can call the Arrays class and over it we have a lot of methods to apply to arrays, like
        byte[] bytes = new byte[]{127,0,0,1};
        System.out.println("local host: " + Arrays.toString(bytes));

   }
}
