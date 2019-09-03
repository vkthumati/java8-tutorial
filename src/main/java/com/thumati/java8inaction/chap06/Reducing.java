package com.thumati.java8inaction.chap06;

import static com.thumati.java8inaction.chap06.Dish.menu;
import static java.util.stream.Collectors.*;

public class Reducing {
    public static void main(String[] args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCalories() {
        return menu.stream()
                    .collect(reducing(0, Dish::getCalories, (a, b)->a+b));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream()
                    .collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors(){
        return menu.stream()
                    .map(Dish::getCalories)
                    .reduce(0, Integer::sum);
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream()
                    .mapToInt(Dish::getCalories)
                    .sum();

    }
}
