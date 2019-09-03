package com.thumati.java8inaction.chap05;

import static com.thumati.java8inaction.chap04.Dish.menu;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.Comparator.comparing;

public class ReduceStreams {
    public static void main(String[] args) {
        System.out.println("==============================================Total Calories==============================================");
        int totalCalories = menu.stream()
                .map(d -> d.getCalories())
                .reduce(0, (a,b)->a+b);
        System.out.println("totalCalories : "+totalCalories);

        System.out.println("==============================================Total Calories==============================================");
        int product = menu.stream()
                .map(d -> d.getCalories())
                .reduce(1, (a,b)->a*b);
        System.out.println("product : "+product);

        System.out.println("==============================================Max Dish Calories==============================================");
        menu.stream()
                .map(d->d.getCalories())
                .reduce(maxBy((a,b)->a.compareTo(b)))
                .ifPresent(System.out::println);

        menu.stream()
                .map(d->d.getCalories())
                .reduce(maxBy(comparing(Integer::intValue)))
                .ifPresent(System.out::println);

        menu.stream()
                .map(d->d.getCalories())
                .reduce(0, Integer::sum);

        menu.stream()
                .map(d->d.getCalories())
                .reduce(Integer::sum);

        System.out.println("==============================================Max Calories==============================================");
        menu.stream()
                .map(d->d.getCalories())
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        System.out.println("==============================================Min Calories==============================================");
        menu.stream()
                .map(d->d.getCalories())
                .reduce(Integer::min)
                .ifPresent(System.out::println);

        System.out.println("==============================================No of Dishes in menu using map and reduce==============================================");
        menu.stream()
                .map(d->1)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
