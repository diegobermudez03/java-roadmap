package com.diegoBermudez.lambda;

import java.util.List;

@FunctionalInterface
public interface ComplexLambda {
    List<Car> transformCars(double price, int years, String...Specifications);
}
