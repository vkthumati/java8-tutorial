package com.thumati.java8inaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN),
                                        new Apple(155, Color.GREEN),
                                        new Apple(120, Color.RED),
                                        new Apple(80, Color.RED),
                                        new Apple(120, Color.GREEN),
                                        new Apple(155, Color.RED)));
        System.out.println(inventory);
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });

        inventory.sort( (a1, a2) -> a1.getWeight()-a2.getWeight() );

        Comparator<Apple> c = Comparator.comparing( a -> a.getWeight());
        inventory.sort(c);

        inventory.sort(comparing(a->a.getWeight()));

        inventory.sort(comparing(Apple::getWeight));

        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);
    }
}
