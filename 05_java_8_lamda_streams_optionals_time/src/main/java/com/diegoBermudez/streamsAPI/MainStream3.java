package com.diegoBermudez.streamsAPI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class MainStream3 {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,7,8,9,2,1);

        Stream<Integer> data = nums.stream();

        data.forEach(System.out::println);

        //won't work the second tume, streams can only be consumed ONCE
       // data.forEach(System.out::println);


        //flatMap, is similar to map, but when mao returns a collection, the flatmap flatterns it so the final result is a single collection
        System.out.println("----------------------------------");
        List<String> transformed = getPersons().stream().flatMap(p-> Stream.of(p.getName(), "hola")).toList();
        transformed.forEach(System.out::println);




        //STREAMS ARE LAZY EVALUATED, IMPORTANT, SO THEY ONLY ACTUALLY EXECUTE WHEN A TERMINAL METHOD RUNS, WHICH IS, A METHOD THAT
        //DOESN'T RETURN ANOTHER STREAM, WHEN IT RUNS, IT WILL RUN WITH THE STATE OF THE COLLECTION AT THE MOMENT OF THE TTERMINAL METHOD
        //NOT OF THE DECLARATION
        System.out.println("----------------------------------------------------------");
        List<Person> people = new LinkedList<>();
        people.add(new Person("juan", 20, true));
        people.add(new Person("luis", 40, true));
        Stream<Person> miStream = people.stream().map((p)->new Person(p.getName(), p.getAge() +5, true));
        people.add(new Person("Gabriela", 19, false));
        miStream.forEach(System.out::println);



        //REGARDING THREADING, IT EXECUTES BY DEFAULT IN THE SAME THREAD, BUT WE CAN EXECUTE IN ANOTHER THREAD BY DOING
        System.out.println("----------------------------------------------------------");
        people.parallelStream().map((p)->new Person(p.getName(), p.getAge() +5, true)).forEach(System.out::println);
        System.out.println("from the main threadddddd");

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
