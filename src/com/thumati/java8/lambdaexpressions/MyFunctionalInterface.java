package com.thumati.java8.lambdaexpressions;

@FunctionalInterface
public interface MyFunctionalInterface<T extends Number> {
    T add(T a, T b);

    boolean equals(Object obj);
}
