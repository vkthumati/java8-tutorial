package com.thumati.corejava.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetUserDefinedObjectExample {
    public static void main(String[] args) {
        /*
           The requirement for a TreeSet of user defined objects is that

           1. Either the class should implement the Comparable interface and provide
              the implementation for the compareTo() function.
           2. Or you should provide a custom Comparator while creating the TreeSet.
        */

        SortedSet<Student> students = new TreeSet<>();

        // TreeSet uses the compareTo() method of the Employee class to compare two employees and sort them
        students.add(new Student(1010, "Rajeev"));
        students.add(new Student(1005, "Sachin"));
        students.add(new Student(1008, "Chris"));

        System.out.println("Students (sorted based on Student class's compareTo() function)");
        System.out.println(students);

        // Providing a Custom Comparator (This comparator compares the employees based on their Name)
        students = new TreeSet<>(Comparator.comparing(Student::getName));

        students.add(new Student(1010, "Rajeev"));
        students.add(new Student(1005, "Sachin"));
        students.add(new Student(1008, "Chris"));

        System.out.println("\nEmployees (sorted based on the supplied Comparator)");
        System.out.println(students);
    }
}
