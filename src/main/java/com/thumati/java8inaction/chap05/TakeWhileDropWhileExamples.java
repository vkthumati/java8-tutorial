package com.thumati.java8inaction.chap05;

import com.thumati.java8inaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TakeWhileDropWhileExamples {
   public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        System.out.println("==========================Filtering============================");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() < 320;
                })
                .collect(toList());
        System.out.println(filteredMenu);
        System.out.println("==========================Take While============================");
        List<Dish> takeWhile = specialMenu.stream()
                .takeWhile(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() < 320;
                }).collect(toList());

        System.out.println("TakeWhile : "+takeWhile);

        System.out.println("==========================Drop While============================");
        List<Dish> dropWhile = specialMenu.stream()
                .dropWhile(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() < 320;
                })
                .collect(toList());
        System.out.println(dropWhile);

        System.out.println("==========================Truncating============================");
        List<Dish> limit = specialMenu.stream()
                .filter(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() > 300;
                })
                .collect(toList());
        System.out.println(limit);

        System.out.println("==========================Skipping============================");
        List<Dish> skip = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(skip);
    }
}
