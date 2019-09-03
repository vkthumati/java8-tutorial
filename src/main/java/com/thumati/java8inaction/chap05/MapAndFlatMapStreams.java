package com.thumati.java8inaction.chap05;

import com.thumati.java8inaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.thumati.java8inaction.chap04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class MapAndFlatMapStreams {
    public static void main(String[] args) {
        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(names);

        List<Integer> length = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(length);

        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> map = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        System.out.println(map);

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> stream = Arrays.stream(arrayOfWords);

        List<Stream<String>> streamList = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);

        Integer[] numbers = {1,2,3,4,5};
        List<Integer> squaresList = Arrays.stream(numbers)
                .map(i -> i * i)
                .collect(toList());
        System.out.println(squaresList);

        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<Integer[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new Integer[]{i, j}))
                .collect(toList());
        System.out.println(pairs);

        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new Integer[]{i, j}))
                .filter(pair -> {
                    int sum=0;
                    for(int n:pair){
                        sum+=n;
                    }
                    return sum%3==0;
                })
                .collect(toList());

        List<Integer[]> pairsSumDivisibleBy3 = numbers1.stream()
                                                        .flatMap(i -> numbers2.stream()
                                                                                .filter(j -> (i+j)%3==0)
                                                                                .map(j -> new Integer[]{i, j}))
                                                        .collect(toList());

        System.out.println(pairsSumDivisibleBy3);

    }
}
