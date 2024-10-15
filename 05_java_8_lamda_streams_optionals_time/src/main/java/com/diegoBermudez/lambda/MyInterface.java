package com.diegoBermudez.lambda;

//the annotation is not mandatory to be able to use lambda, but is best practice, and it enforces to have only 1 method
@FunctionalInterface
public interface MyInterface {
    void myFunction();
}
