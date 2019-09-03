package com.thumati.java8inaction.chap05;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilterAndDistinctStreams {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 1, 2, 3, 3, 4, 4);

        List<Integer> evenIntegers = integers.stream()
                .filter(i -> i % 2 == 0)
                .collect(toList());
        System.out.println(evenIntegers);

        integers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
