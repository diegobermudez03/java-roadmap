package com.diegoBermudez.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//in order to only target classes
@Target(ElementType.TYPE)
//@Target({ElementType.TYPE, ElementType.Constructor}) ...
@Retention(RetentionPolicy.RUNTIME)
//RUNTEIME = EXECUTION
//SOURCE = ONLY WHEN CODING
//CLASS = ON COMPILATION
public @interface Veryimportant {
}
