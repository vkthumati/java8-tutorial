package com.thumati.java8inaction.chap04;

import com.thumati.java8inaction.chap03.Apple;
import com.thumati.java8inaction.chap03.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.thumati.java8inaction.chap04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class HighCaloriesNames {
    public static void main(String[] args) {
        /*List<String> names = menu.stream().filter(d -> {
            System.out.println("filtering " + d.getName());
            return d.getCalories() > 300;
        })
        .map(d -> {
            System.out.println("mapping " + d.getName());
            return d.getName();
        })
        .limit(3)
        .collect(toList());
        System.out.println(names);*/

        /*List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(80, Color.RED),
                new Apple(120, Color.GREEN),
                new Apple(155, Color.RED)));

        //inventory.forEach(d->d.setColor(Color.RED));
        System.out.println("===========Iterable forEach==================");
        inventory.forEach(System.out::println);
        System.out.println("===========Stream forEach==================");
        inventory.stream().forEach(System.out::println);*/

        Stream<String> limit = menu.stream().filter(d -> {
            System.out.println("filtering " + d.getName());
            return d.getCalories() > 300;
        })
        .map(d -> {
            System.out.println("mapping " + d.getName());
            return d.getName();
        })
        .limit(3);

        System.out.println(limit);
    }
}
