package com.thumati.java8.lambdaexpressions;

@FunctionalInterface
interface Converter<F, T>{
    T convert(F from);
}

