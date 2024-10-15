package com.diegoBermudez.innerClasses;

public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        outer.heyThere();

        //a non static innet class, we need the outer instance
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.whatsUp();

        //a static inner class, which means, is like
        //a static attribute from a class, it can be accessible without an instance
        OuterClass.InnerClass2 inner2 = new OuterClass.InnerClass2();
        inner2.whatsGoing();
    }
}
