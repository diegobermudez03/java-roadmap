package com.diegoBermudez.instanceOfPatternMatch;

public class Main {
    public static void main(String[] args) {
        Person juan = new Student("Juan diego", 20, 1001);
        Person piloto = new Pilot("julian", 20, 100);

        //before
        if(piloto instanceof Student){
            Student aux = (Student) juan;
            System.out.println("the code is " + aux.getCode());
        }else{
            System.out.println("It wasn't a student");
        }
        //or
        if(juan.getClass().getName().contains("Student")){
            Student aux = (Student) juan;
            System.out.println("the code is " + aux.getCode());
        }else{
            System.out.println("It wasn't a student");
        }

        //Now with the pattern
        if(juan instanceof Student aux){
            System.out.println("the code is " + aux.getCode());
        }else{
            System.out.println("It wasn't a student");
        }

    }
}
