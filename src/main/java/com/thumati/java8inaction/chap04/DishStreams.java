package com.thumati.java8inaction.chap04;

import static com.thumati.java8inaction.chap04.Dish.menu;

public class DishStreams {
    public static void main(String[] args) {
        menu.stream()
             .map(Dish::getCalories)
             .reduce(Integer::sum)
             .ifPresent(System.out::println);
    }
}
