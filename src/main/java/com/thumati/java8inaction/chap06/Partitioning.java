package com.thumati.java8inaction.chap06;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static com.thumati.java8inaction.chap06.Dish.menu;

public class Partitioning {
    public static void main(String[] args) {
        System.out.println("Menu partitioned By Vegetarian :"+partitionedMenu());
        System.out.println("Menu partitioned By Vegetarian and By Type :"+vegetarianDishesByType());
        System.out.println("Menu partitioned By Vegetarian and Most Caloric Dish :"+mostCaloricPartitionedByVegetarian());
        System.out.println("PartitionedByVegetarianAndCalories : "+partitionedByVegetarianAndCalories());
        System.out.println("PartitionedByVegetarianAndCount : "+partitionedByVegetarianAndCount());
    }

    private static Map<Boolean, List<Dish>> partitionedMenu(){
        return menu.stream()
            .collect(partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType(){
        return menu.stream()
            .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }

    private static Map<Boolean, Dish> mostCaloricPartitionedByVegetarian(){
        return menu.stream()
             .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparing(Dish::getCalories)), Optional::get)));
    }

    private static Map<Boolean, Map<Boolean, List<Dish>>> partitionedByVegetarianAndCalories(){
        return menu.stream()
             .collect(partitioningBy(Dish::isVegetarian, partitioningBy(dish -> dish.getCalories()>500)));
    }

    private static Map<Boolean, Long> partitionedByVegetarianAndCount(){
       return menu.stream()
             .collect(partitioningBy(Dish::isVegetarian, counting()));
    }
}
