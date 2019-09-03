package com.thumati.java8.functionalinterfaces;

import com.thumati.java8.lambdaexpressions.Person;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Comparator<Person> personComparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        //Comparable<Person> personComparable = p ->
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        int i = personComparator.compare(p1, p2); // >0
        int j = personComparator.reversed().compare(p1, p2); //<0
    }
}
