package com.thumati.java8inaction.chap05;

import com.thumati.java8inaction.chap04.Dish;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.thumati.java8inaction.chap04.Dish.menu;

public class NumericStreams {
    public static void main(String[] args) {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        //System.out.println(intStream.max());

        Stream<Integer> stream = intStream.boxed();

        IntStream evenNumbers = IntStream.rangeClosed(1,100)
                    .filter(n->n%2==0);
        System.out.println("Total No.of Even numbers : "+evenNumbers.count());

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1,100)
                 .boxed()
                 .flatMap( a ->
                    IntStream.rangeClosed(a,100)
                              .filter( b -> Math.sqrt(a*a + b*b)%1==0 )
                              .mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
                 );
        System.out.println("=================================Pythagorean Triples=================================");
        pythagoreanTriples.forEach(t -> System.out.println(t[0]+","+t[1]+","+t[2]));

        System.out.println("=================================Better Version of Pythagorean Triples=================================");
        IntStream.rangeClosed(1, 100).boxed()
                    .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                            .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a+b*b)})
                                            .filter(t -> t[2]%1 ==0)
                    )
                    .forEach(t -> System.out.println(t[0]+","+t[1]+","+t[2]));


    }
}
