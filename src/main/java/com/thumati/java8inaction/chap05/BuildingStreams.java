package com.thumati.java8inaction.chap05;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");

        stream.map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("============================================================================================");
        Stream<String> emptyStream = Stream.empty();

        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);
        homeValueStream.forEach(System.out::println);
        System.out.println("============================================================================================");
        Stream<String> values = Stream.of("config", "user.home", "user.name", "java.home");
        values.flatMap(key -> Stream.ofNullable(System.getProperty(key)))
                .forEach(System.out::println);
        System.out.println("============================================================================================");
        System.getProperties().keySet().stream()
                                        //.forEach(System.out::println);
                                        .flatMap(key -> Stream.ofNullable(System.getProperty((String)key)))
                                        .forEach(System.out::println);
        System.out.println("============================================================================================");

        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum : "+sum);
    }
}
