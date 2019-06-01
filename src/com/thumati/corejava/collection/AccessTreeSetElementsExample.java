package com.thumati.corejava.collection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Find the size of a TreeSet.
 * Check if an element exists in a TreeSet.
 * Find the first element in the TreeSet.
 * Find the last element in the TreeSet.
 * Find the element just higher than the given element in the TreeSet.
 * Find the element just lower than the given element in the TreeSet.
 */
public class AccessTreeSetElementsExample {
    public static void main(String[] args) {
        TreeSet<String> students = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        students.add("Julia");
        students.add("Robert");
        students.add("Mark");
        students.add("Steven");

        System.out.println("Students TreeSet : " + students);

        // Finding the size of a TreeSet
        System.out.println("Number of elements in the TreeSet : " + students.size());

        // Check if an element exists in the TreeSet
        String name = "Julia";
        if(students.contains(name)) {
            System.out.println("TreeSet contains the element : " + name);
        } else {
            System.out.println("TreeSet does not contain the element : " + name);
        }

        // Navigating through the TreeSet
        System.out.println("First element : " + students.first());
        System.out.println("Last element : " + students.last());

        name = "Robert";
        System.out.println("Element just greater than "  + name + " : " + students.higher(name));
        System.out.println("Element just lower than "  + name + " : " + students.lower(name));
    }
}
