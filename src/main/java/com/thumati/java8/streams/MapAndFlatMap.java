package com.thumati.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //stream.forEach(System.out::print);
        //List<Integer> list = stream.map(e->Integer.valueOf(e)).collect(Collectors.toList());
        List<Integer> integerList = stream.map(Integer::valueOf).collect(Collectors.toList());

        Stream<Integer> evensStream = Stream.of(2, 4, 6, 8);

        List<Integer> evensList = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> oddsList = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> primesList = Arrays.asList(2, 3, 5, 7, 11);

        Stream<List<Integer>> streamOfLists = Stream.of(evensList, oddsList, primesList);
        System.out.println("streamOfLists : "+streamOfLists);

        List<Integer> flatList = streamOfLists.flatMap( list -> list.stream()).collect(Collectors.toList());
        System.out.println("flatList : "+flatList);

        System.out.println("\n\n");
        flatList.forEach(System.out::print);
    }
}
