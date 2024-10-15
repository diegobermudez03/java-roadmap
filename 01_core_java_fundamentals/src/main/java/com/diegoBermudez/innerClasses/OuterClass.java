package com.diegoBermudez.innerClasses;

public class OuterClass {
    int number = 6;

    public void heyThere(){
        System.out.println("hey there");

        //not used in real life, but it's an inner class insie a method
        class LocalInnerClass {
            private String  localInnerClassVariable = "Here's Johny";

            public void printLocalInnerClass(){
                System.out.println(localInnerClassVariable);
            }
        }
        LocalInnerClass local = new LocalInnerClass();
        local.printLocalInnerClass();

    }

    public class InnerClass{
        int innerNumber = 8;

        public void whatsUp(){
            System.out.println("whats up");
        }
    }

    public static class InnerClass2 {
        int innerN = 12;

        public void whatsGoing(){
            System.out.println("what's going on");
        }
    }
}
