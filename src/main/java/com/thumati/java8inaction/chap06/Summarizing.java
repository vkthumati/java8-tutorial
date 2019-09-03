package com.thumati.java8inaction.chap06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import static com.thumati.java8inaction.chap06.Dish.menu;

public class Summarizing {
    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes(){
       /* menu.stream()
                .count();*/
        return menu.stream()
             .collect(counting());
    }

    private static Dish findMostCaloricDish() {
       /* return menu.stream()
                .collect(maxBy(comparing(Dish::getCalories)))
                .get();*/

       return menu.stream()
                .collect(reducing( (d1,d2)-> d1.getCalories()>d2.getCalories()?d1:d2 ) ).get();

       /* return menu.stream()
                .max(comparing(Dish::getCalories))
                .get();*/
    }

    private static Dish findMostCaloricDishUsingComparator(){
        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricDish = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream()
            .collect(reducing(moreCaloricDish)).get();
    }

    private static int calculateTotalCalories(){
        return menu.stream()
                .collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return menu.stream()
                .collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream()
                .collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream()
                    .map(Dish::getName)
                    .collect(joining());
    }

    private static String getShortMenuCommaSeparated(){
        return menu.stream()
                    .map(Dish::getName)
                    .collect(joining(","));
    }
}
