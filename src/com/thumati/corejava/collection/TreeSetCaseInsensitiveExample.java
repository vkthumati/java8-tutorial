package com.thumati.corejava.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetCaseInsensitiveExample {
    public static void main(String[] args) {
        // Creating a TreeSet with a custom Comparator (Case Insensitive Order)
        SortedSet<String> fruits = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        /*SortedSet<String> fruits = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/

        //SortedSet<String> fruits = new TreeSet<>( (s1, s2) -> s1.compareToIgnoreCase(s2));

        // Adding new elements to a TreeSet
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        System.out.println("Fruits Set : " + fruits);

        // Now, lowercase elements will also be considered as duplicates
        fruits.add("banana");
        System.out.println("After adding \"banana\" : " + fruits);
    }
}
