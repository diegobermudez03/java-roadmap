package com.diegoBermudez.lambda;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Lambda is only a syntax way to do anonymous classes, but lamda only work with
        //functional interfaces, which are interfaces that only have 1 method, because if it had more, then the mabda wouldn't know
        //which one is implementing

        MyInterface funcTraditional = new MyInterface() {
            @Override
            public void myFunction() {
                System.out.println("Hello from the traditional method");
            }
        };

        MyInterface funcLamda = ()-> System.out.println("Hello from the lamda");
        funcTraditional.myFunction();
        funcLamda.myFunction();

        //if we want with more than one method, we can't use lambda
        System.out.println("---------------------------------------------------------");
        NonFunctionalInterface nonFunc = new NonFunctionalInterface() {
            @Override
            public void calculate(int a, int b) {
                System.out.println("the age seems to be " + (a+b));
            }

            @Override
            public int guessTheAge() {
                return (int)(Math.random()*100);
            }
        };
        callNonFuncMethods(nonFunc);


        //LAMBDA EXAMPLES
        System.out.println("----------------------------------------------------------");
        getLambda((p, y, spec)->{
            LinkedList<Car> cars = new LinkedList<>();
            cars.add(new Car(2000 + y, "kawasaki" + spec[0]));
            cars.add(new Car(1990 + y, "honda" + spec[0]));
            cars.add(new Car(1980 + y, "mazda" + spec[0]));
            return cars;
        });

        //AS YOU KNOW, MANY OF THE BUILT IN FUNCTIONALITIES OF JAVA USED FUNCTIONAL INTERFACES, SUCH AS RUNNABLE, THAT
        //CAN BE REPLACED WITH LAMBDA
        System.out.println("--------------------------------------------------");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hiiii, from thread in the traditional way");
            }
        });
        Thread t2 = new Thread(()-> System.out.println("Hi from the lambda of runnable"));
        Runnable run = ()-> System.out.println("hi from the runnable itself");
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(500);


        //Now, lets create our generic functional interfaces so we can use them for different types of funcitons
        System.out.println("------------------------------------------------------");
        GenericFunction2Param<Integer, String, Double> func1 = (string, doble)-> 100;
        GenericFunction2Param<Car, String, Integer> func2 = (model, year) -> new Car(year, model);
        GenericFunction2Param<Integer, Integer, Integer> func3 = (p1, p2)->{
            int number = p1+p2;
            return (int)number/8;
        };
        System.out.println(func1.play("h", 10D));
        System.out.println(func2.play("Honda", 2011));
        System.out.println(func3.play(80, 90));
        System.out.println(call(func2, "Mazda", 1990));

    }



    private static <T,R,Z>T  call(GenericFunction2Param<T, R, Z> func, R pam1, Z pam2){
        return func.play(pam1, pam2);
    }

    private static void getLambda(ComplexLambda complexLambda){
        List<Car> cars = complexLambda.transformCars(201.2,30, "NEW", "FAST");
        for(Car c: cars){
            System.out.println(c);
        }
    }

    private static void callNonFuncMethods(NonFunctionalInterface nonFunc){
        nonFunc.calculate(10,30);
        System.out.println("AGE GUESED: " +nonFunc.guessTheAge());
    }

}
