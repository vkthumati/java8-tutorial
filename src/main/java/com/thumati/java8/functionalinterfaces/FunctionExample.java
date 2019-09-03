package com.thumati.java8.functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        String strResult = backToString.apply("123");
        Integer intResult = toInteger.apply("321");
    }
}
