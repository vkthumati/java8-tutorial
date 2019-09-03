package com.thumati.java8inaction.chap05;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenarteStreamsInfinite {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("\n===========================================================================================");

        IntStream.generate(() ->1)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("\n===========================================================================================");
        IntSupplier fib = new IntSupplier() {
            private int previous=0;
            private int current=1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous+this.current;
                this.previous = current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib)
                .limit(20)
                .forEach(i -> System.out.print(i+", "));
    }
}
