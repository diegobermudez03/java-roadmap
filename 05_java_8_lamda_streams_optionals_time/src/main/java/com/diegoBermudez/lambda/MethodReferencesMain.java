package com.diegoBermudez.lambda;

import java.util.function.Function;

public class MethodReferencesMain {

    public static void main(String[] args) throws InterruptedException {
        //Method reference is a way to pass a method even easier, when we want to simply pass as the
        //callback method a method of a class or an instance. check this out
        final Car car1 = new Car(2011, "Toyota");
        Car car2 = new Car(2011, "Toyota");
        //without method reference
        methodCall((p1, p2)->{
            return car1.myMethod(p1, p2);
        });
        //with method reference
        methodCall(car2::myMethod);

        //And check that even, with the method reference, the car doesn't need to be final, whereas with the lamda it does.


        //CLASS METHODS
        System.out.println("---------------------------------------------");
        Function<String, Integer> func = Integer::parseInt;
        System.out.println(func.apply("90"));


        //showing you that now the method doesn't need to be final
        System.out.println("------------------------------------");
        car2 = new Car(2020, "Mazda");
        methodCall(car2::myMethod);

        //WITH THREADS
        System.out.println("--------------------------------------------");
        Thread t1 = new Thread(car2::carRun);
        t1.start();
        t1.join();

        //checking if it preserves the same car reference
        System.out.println("------------------------------------------");
        Car newCar = new Car(2010, "BMW");
        Thread tx = new Thread(newCar::carRun);
        newCar = new Car(2020, "MERCEDES");
        Thread ty = new Thread(newCar::carRun);
        tx.start();
        ty.start();

        //the reason why method references don't need the variable to be final, it's because the method references
        //keep track of the object itself (reference), not the variable, whereas lambda (anonymous classes), keep track of the
        //variable, even when method references is syntatic sugar for lambda, it manages different that stuff, we could
        //achieve the same by creating a class "Holder" for our object, and then, inside that holder having the actual instance that
        //can change

        //the reason why it works that way, it's because lambda/anonymous can work with both, objects or primitives, so it works
        //with variables, not references, but method reference is literally a reference to the object which we want to call the method from
        //so it knows that it will be an object


    }

    private static void methodCall(GenericFunction2Param<Integer, Double, Double> func){
        System.out.println("lets run the function passed");
        func.play(10.2, 856.5);
    }
}
