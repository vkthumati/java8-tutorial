package com.thumati.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sort : "+list);
        Collections.sort(list);
        System.out.println("After sort : "+list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("After sort with custom comparator : "+list);

        Collections.sort(list, (a, b) -> a.compareTo(b));

        System.out.println("After sort with custom comparator using lambda expression : "+list);

        Predicate<String> p = s -> list.add(s);
        Consumer<String> c = s -> list.add(s);

        //Thread.currentThread().dumpStack();

        String str = new String("Hello");
        str.length();
    }
}
