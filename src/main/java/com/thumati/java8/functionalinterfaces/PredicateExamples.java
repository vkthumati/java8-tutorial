package com.thumati.java8.functionalinterfaces;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExamples {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = s -> s.length()>0;
        System.out.println(stringPredicate.test("Vasanth"));
        System.out.println(stringPredicate.test(""));
        System.out.println(stringPredicate.negate().test("Vasanth"));
        System.out.println(stringPredicate.negate().test(""));

        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println("isNull : "+isNull.test(true));
        System.out.println("isNull : "+isNull.test(null));

        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println("nonNull : "+nonNull.test(true));
        System.out.println("nonNull : "+nonNull.test(null));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println("isEmpty : "+isEmpty.test("Hello"));
        System.out.println("isNotEmpty : "+isNotEmpty.test("Hello"));
    }
}
