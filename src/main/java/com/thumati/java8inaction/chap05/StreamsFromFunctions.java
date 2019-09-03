package com.thumati.java8inaction.chap05;

import java.util.stream.Stream;

public class StreamsFromFunctions {
    public static void main(String[] args) {
        Stream.iterate(0, n->n+2)
                .limit(1000)
                .forEach(System.out::println);
    }
}
