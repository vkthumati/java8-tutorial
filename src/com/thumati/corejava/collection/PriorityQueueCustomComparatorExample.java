package com.thumati.corejava.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCustomComparatorExample {
    public static void main(String[] args) {

        // A custom comparator that compares two Strings by their length.
        //Comparator<String> stringLengthComparator = (s1, s2) -> s1.length() - s2.length();
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);

        // Add items to a Priority Queue (ENQUEUE)
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        while(!namePriorityQueue.isEmpty())
            System.out.println(namePriorityQueue.remove());

    }
}
