package com.thumati.java8.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

        strings.stream()
                .filter( s -> s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("Sorted Collection .....................");
        strings.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("After Sorted Collection .....................");
        System.out.println(strings);

        System.out.println("Stream Map operation .....................");
        strings.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("Stream Match operation .....................");
        boolean anyStartsWithA = strings.stream()
                .anyMatch(s->s.startsWith("a"));
        System.out.println("anyStartsWithA : "+anyStartsWithA);

        boolean allStartsWithA = strings.stream()
                .allMatch(s->s.startsWith("a"));
        System.out.println("allStartsWithA : "+allStartsWithA);

        boolean noneStartsWithZ = strings.stream()
                .noneMatch(s->s.startsWith("z"));
        System.out.println("noneStartsWithZ : "+noneStartsWithZ);

        System.out.println("Stream Count operation .....................");
        long count = strings.stream()
                            .filter(s->s.startsWith("b"))
                            .count();
        System.out.println("Count startsWithB : " +count);

        System.out.println("Stream Reduced operation .....................");
        Optional<String> reduced = strings.stream()
                .sorted()
                .reduce((s1, s2)->s1+"#"+s2);
        reduced.ifPresent(System.out::println);
    }
}
