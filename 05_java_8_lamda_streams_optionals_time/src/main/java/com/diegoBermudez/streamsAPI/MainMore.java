package com.diegoBermudez.streamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainMore {
    public static void main(String[] args) {
        //here we will see more methods from streams

        //skip
        IntStream.range(1,10).skip(5).forEach(System.out::println);


        System.out.println("--------------------------------");
        //sum
        System.out.println(IntStream.range(1,10).sum());


        System.out.println("--------------------------------");
        //find first
        Stream.of("Juan", "Bubu", "Tibata", "Pablo").sorted().findFirst().ifPresent(System.out::println);


        System.out.println("----------------------------------------------------");
        //AVARAGE
        Arrays.stream(new int[]{2,6,8,10,85,410,50}).map(num->num*num).average().ifPresent(System.out::println);


        System.out.println("-------------------------------------------");
        //count
        System.out.println(Arrays.stream(new int[]{2,6,8,10,85,410,50}).count());


        System.out.println("--------------------------------------------");
        //reduce
        IntStream.range(1,80).reduce((acum, next)->acum+ (next*10)).ifPresent(System.out::println);
    }


    private static List<Person> getPersons(){
        return List.of(
                new Person("Juan", 20, true),
                new Person("Bubu bebe", 19, false),
                new Person("Luis", 80, true),
                new Person("Augusto", 80, true)
        );
    }
}
