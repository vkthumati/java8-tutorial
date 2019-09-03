package com.thumati.java8inaction.chap03;

import java.util.function.Predicate;
import static com.thumati.java8inaction.chap03.Color.GREEN;
import static com.thumati.java8inaction.chap03.Color.RED;

public class ComposePredicate {
    public static void main(String[] args) {
        Predicate<Apple> redApple = a -> a.getColor().equals(Color.RED);
        System.out.println(redApple.test(new Apple(120, Color.RED)));
        System.out.println(redApple.test(new Apple(120, Color.GREEN)));
        System.out.println("\n");
        Predicate<Apple> notRedApple = redApple.negate();
        System.out.println(notRedApple.test(new Apple(155, Color.RED)));
        System.out.println(notRedApple.test(new Apple(155, Color.GREEN)));

        Predicate<Apple> redAndHeavy = redApple.and(a -> a.getWeight()>250);
        System.out.println("Red And Heavy : "+redAndHeavy.test(new Apple(312, Color.RED)));

        Predicate<Apple> redAndHeavyAppleOrGreenOnly = redApple.and(a->a.getWeight()>250).or(a->GREEN.equals(a.getColor()));
        System.out.println("Red And Heavy  or Green Only : "+redAndHeavyAppleOrGreenOnly.test(new Apple(100, GREEN)));
        System.out.println("Red And Heavy  or Green Only : "+redAndHeavyAppleOrGreenOnly.test(new Apple(251, RED)));
    }
}
