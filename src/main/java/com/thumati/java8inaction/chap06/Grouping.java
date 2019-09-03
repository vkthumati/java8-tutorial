package com.thumati.java8inaction.chap06;

import java.util.*;

import static com.thumati.java8inaction.chap06.Dish.menu;
import static com.thumati.java8inaction.chap06.Dish.dishTags;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class Grouping {
    enum CaloricLevel {
        DIET, NORMAL, FAT
    };

    private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
         return menu.stream().
                 collect( groupingBy( Dish::getType, flatMapping( d ->dishTags.get(d.getName() ).stream(), toSet() ) ) );
    }

    public static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    private static Map<Dish.Type, List<Dish>> groupCaloricDishesByType(){
        return menu.stream()
             .collect(groupingBy(Dish::getType, filtering(d->d.getCalories()>=500, toList())));
       /* return menu.stream()
                    .filter(d -> d.getCalories()>=500)
                    .collect(groupingBy(Dish::getType));*/
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel(){
        return menu.stream()
             .collect(groupingBy(dish -> {
                 if(dish.getCalories()<=400)
                     return CaloricLevel.DIET;
                 else if(dish.getCalories()<=700)
                     return CaloricLevel.NORMAL;
                 else
                     return CaloricLevel.FAT;
             }));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevelUsingMethodReference(){
        return menu.stream()
                    .collect(groupingBy(Dish::getCaloricLevel));
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel(){
        return menu.stream()
             .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                 if(dish.getCalories()<=400)
                     return CaloricLevel.DIET;
                 else if(dish.getCalories()<=700)
                     return CaloricLevel.NORMAL;
                 else
                     return CaloricLevel.FAT;
             })));
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevelUsingMethodReference(){
        return menu.stream()
                    .collect(groupingBy(Dish::getType, groupingBy(Dish::getCaloricLevel)));
    }

    private static Map<Dish.Type, Long> countDishesInGroups(){
        return menu.stream()
             .collect(groupingBy(Dish::getType, counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType(){
        menu.stream()
                .collect(groupingBy(Dish::getType, reducing( (d1,d2)->d1.getCalories()>d2.getCalories()?d1:d2 )));

        return menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparing(Dish::getCalories))));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals(){
        return menu.stream()
             .collect(groupingBy(Dish::getType, collectingAndThen( maxBy(comparing(Dish::getCalories)), Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType(){
        return menu.stream()
            .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType(){
       return menu.stream()
             .collect(groupingBy(Dish::getType, mapping(dish -> {
                 if(dish.getCalories()<=400)
                     return CaloricLevel.DIET;
                 else if(dish.getCalories()<=700)
                     return CaloricLevel.NORMAL;
                 else
                     return CaloricLevel.FAT;
             }, toSet())));
    }

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Dish names grouped by type: " + groupDishNamesByType());
        System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
        System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
        System.out.println("Count dishes in groups: " + countDishesInGroups());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
        System.out.println("Sum calories by type: " + sumCaloriesByType());
        System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }
}
