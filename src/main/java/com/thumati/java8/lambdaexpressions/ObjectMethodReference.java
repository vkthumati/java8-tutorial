package com.thumati.java8.lambdaexpressions;

public class ObjectMethodReference {
    public static void main(String[] args) {
        Something something = new Something();
        Converter<String, String> converter = something::startWith;
        String str = converter.convert("Hello");
    }
}

