package com.thumati.java8inaction.chap05;

import com.thumati.java8inaction.chap04.Dish;

import java.util.Arrays;
import java.util.Optional;

import static com.thumati.java8inaction.chap04.Dish.menu;

public class FindingAndMatching {
    public static void main(String[] args) {
        System.out.println("==============================AnyMatch=======================================");
        boolean isVegetarian = menu.stream()
                .anyMatch(d -> {
                    System.out.println(d.getName());
                    return d.isVegetarian();
                });
        if(isVegetarian)
            System.out.println("The menu is (somewhat) vegetarian friendly!!");

        System.out.println("==============================AllMatch=======================================");
        boolean isHealthy = menu.stream()
                                .allMatch(d -> {
                                    System.out.println(d.getName());
                                    return d.getCalories()<1000;
                                });
        if(isHealthy)
            System.out.println("Menu is Healthy");

        System.out.println("==============================NoneMatch=======================================");
        boolean noneMatch = menu.stream()
                                .noneMatch(d -> {
                                                    System.out.println(d.getName());
                                                    return d.getCalories()>=1000;
                                                });
        if(noneMatch)
            System.out.println("NoneMatch is true");

        System.out.println("==============================FindAny=======================================");
        Optional<Dish> dishFindAny = menu.stream()
                .filter(d -> {
                    System.out.println(d.getName());
                    return d.isVegetarian();
                })
                .findAny();

        System.out.println("isPresent : "+dishFindAny.isPresent());
        System.out.println("if it is not present then default valuer : "+dishFindAny.orElse(new Dish("Dosa", true, 400, Dish.Type.OTHER)));
        System.out.println("Dish : "+dishFindAny.get());
        dishFindAny.ifPresent(d -> {
            System.out.println("Name : "+d.getName());
            System.out.println("isVegetarian : "+d.isVegetarian());
            System.out.println("calories : "+d.getCalories());
            System.out.println("Type : "+d.getType());
        });

        System.out.println("==============================Optional IfPresent=======================================");
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("==============================Find First=======================================");
        Arrays.asList(1,2,3,4,5).stream()
                .filter(n -> (n*n)%3==0 )
                .findAny()
                .ifPresent(System.out::println);
        System.out.println("----------------------");
        Arrays.asList(1,2,3,4,5).stream()
                .map(n -> {
                    System.out.println("Map : "+n);
                    return n*n;})
                .filter(n -> {
                    System.out.println("filter : "+n);
                    return n%3==0; })
                .findFirst()
                .ifPresent(System.out::println);
    }
}
