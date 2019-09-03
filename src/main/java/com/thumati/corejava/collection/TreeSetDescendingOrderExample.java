package com.thumati.corejava.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDescendingOrderExample {
    public static void main(String[] args) {
        // Creating a TreeSet with a custom Comparator (Descending  Order)
        SortedSet<String> fruits = new TreeSet<>(Comparator.reverseOrder());

        /*SortedSet<String> fruits = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/

        //SortedSet<String> fruits = new TreeSet<>( (s1, s2)-> s2.compareTo(s1));

        // Adding new elements to a TreeSet
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        System.out.println("Fruits Set : " + fruits);
    }
}
