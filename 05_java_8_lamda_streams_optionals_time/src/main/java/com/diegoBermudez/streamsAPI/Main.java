package com.diegoBermudez.streamsAPI;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPersons();
        List<Person> females = new LinkedList<>();
        //before, imperative way
        for(Person p: people){
            System.out.println(p.toString());
        }

        //with forEach, declarative way
        System.out.println("---------------------------------------");
        people.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        people.forEach(p-> System.out.println(p));
        people.forEach(System.out::println);    //this is the actuall best approach, the aboves is to understand behind the scenes


        //JAVA STREAMS, DECLARATIVE APPROACH
        //there are more methods than this ones, check the other Main class to see more
        //filter
        //sort
        //all match
        //any match
        //none match
        //max
        //min
        //map
        //group

        //before, imperative way
        for(Person p: people){
            if(!p.isMale()) females.add(p);
        }
        //after
        List<Person> females2 = people.stream().filter(person-> !person.isMale()).collect(Collectors.toList());
        females2.forEach(f-> System.out.println(f.getName()));
        System.out.println("------------------------------------");
        females2.forEach(System.out::println);


        //sorting
        System.out.println("--------------------------------------------");
        List<Person> sorted = people.stream().sorted((first, second)-> first.getAge() - second.getAge()).toList();
        List<Person> sorted2= people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).toList();
        sorted.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++");
        sorted2.forEach(System.out::println);

        //then comparing, is like ordering in groups
        System.out.println("--------------------------------------------");
        sorted = people.stream().sorted((first, second)-> {
            int ageDif = first.getAge() - second.getAge();
            int result = ageDif;
            if(ageDif == 0){
                result = first.getName().compareTo(second.getName());
            }
            return result;
        }).toList();
        sorted2= people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).toList();
        sorted.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++");
        sorted2.forEach(System.out::println);


        //All match, Any match, NoneMatch
        boolean todos = people.stream().allMatch(p->p.getAge()>20);
        System.out.println(todos ? "si son todos mayores " : "no son todos mayores");
        boolean alguno = people.stream().anyMatch(p->p.getAge()>20);
        System.out.println(alguno ? "si son algunos mayores " : "no son algunos mayores");
        boolean ninguno = people.stream().noneMatch(p->p.getAge()>20);
        System.out.println(ninguno ? "si son todos menores " : "no son todos menores");

        //Max, Min
        System.out.println("-----------------------------------");
        //returns an optional
        Optional<Person> mayor = people.stream().max((first, second) -> first.getAge() - second.getAge());
        //example with Comparator, and unboxing the optional in the same chain
        Person mayor2 = people.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println("el mayor es " + mayor.get().getName() +" y yo confirmo con " + mayor2.getName());


        //Group
        //this function is collected through a map, where the key is the key of grouping, and the value is a list of the values
        Map<Boolean, List<Person>> personas = people.stream().collect(Collectors.groupingBy(Person::isMale));
        //with our own comparator
        Map<Boolean, List<Person>> personas2 = people.stream().collect(Collectors.groupingBy(p->p.isMale()));
        System.out.println("----------------------------------------");
        personas.forEach((key, list)-> {
            System.out.println("of type  " +( key? "Male":"female"));
            list.forEach(System.out::println);
        });


        //MAP
        //finally, same as in js, dart, c# (linq), we can chain the methods, they need to be coherent based on the the result values
        System.out.println("---------------------------------------------------------");
        people.stream().filter(Person::isMale).map(p->new Person(p.getName(), p.getAge()+10, true))
                .sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
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
