package com.diegoBermudez.anonymousClass2;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(1500, 2011);
        int number1 = 90;

        //VARIABLES FROM THE OUTER SCOPE, NEED TO BE FINAL OR EFFECTEVILY FINAL
        //WHICH MEANS, WE CAN ONLY READ THEM FROM THE INNER CLASS, OR CALL ITS METHODS IF ITS
        //AN OBJECT, BUT WE CAN'T MODIFY THEM, ONLY OBJECTS IF IT'S THROUGH METHODS.

        //we don't need to declare the variables as final obligatory, but, we can't change them, even
        //in the outer scope, if we do so, then they won't be considered as final and we won't be able to use them
        Person juan = new Person("juan diego"){
            @Override
            public void doAction(){
                System.out.println("in the inner class the car is: " + car1);
                car1.modify(1200, 2000);
                this.name = "juan2 diego2";
                System.out.println(number1);
            }
        };


        /*CAN'T DO THIS BECAUSE THEY WOULDN'T BE FINAL
        car1 = new Car(10, 1990);
        number1 = 52;
         */
        car1.modify(10, 1990);
        juan.doAction();

        System.out.println(car1);


    }
}
