package com.thumati.java8inaction.chap05;

import java.util.stream.Stream;

public class IterateStreamFibonacciSeries {
   public static void main(String[] args) {
        Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0]+f[1]})
                .limit(20)
                .forEach(t -> System.out.print("("+t[0]+","+t[1]+"), "));
        System.out.println("\n===========================================================================================");

        Stream.iterate(0, n->n<100, n->n+4)
                .forEach(n-> System.out.print(n+", "));
        System.out.println("\n===========================================================================================");

        Stream.iterate(0, n->n+4)
                .takeWhile(n->n<100)
                .forEach(n-> System.out.print(n+", "));

        System.out.println("\n===========================================================================================");
    }
}
