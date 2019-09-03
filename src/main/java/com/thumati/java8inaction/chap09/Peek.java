package com.thumati.java8inaction.chap09;

import java.util.stream.Stream;

public class Peek {
    public static void main(String[] args) {
        Stream.of(2, 3, 4, 5)
                .peek(x-> System.out.println("Taking from stream"));
    }
}
