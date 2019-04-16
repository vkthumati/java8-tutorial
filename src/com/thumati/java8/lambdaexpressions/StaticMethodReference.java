package com.thumati.java8.lambdaexpressions;

public class StaticMethodReference {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer i = converter.convert("123");

        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer i1 = converter1.convert("321");
    }
}

