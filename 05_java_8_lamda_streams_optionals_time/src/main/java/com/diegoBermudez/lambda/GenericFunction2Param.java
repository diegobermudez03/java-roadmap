package com.diegoBermudez.lambda;

@FunctionalInterface
public interface GenericFunction2Param<T, R, Z> {

    T play(R p1, Z p2);
}
