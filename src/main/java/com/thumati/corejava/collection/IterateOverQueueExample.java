package com.thumati.corejava.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IterateOverQueueExample {
    public static void main(String[] args) {
        Queue<String> waitingQueue = new LinkedList<>();

        waitingQueue.add("John");
        waitingQueue.add("Brad");
        waitingQueue.add("Angelina");
        waitingQueue.add("Julia");

        System.out.println("=== Iterating over a Queue using Java 8 forEach() ===");
        waitingQueue.forEach( e -> System.out.print(e+", "));

        System.out.println("\n\n=== Iterating over a Queue using for-each loop ===");
        for(String name : waitingQueue){
            System.out.print(name+", ");
        }

        System.out.println("\n\n=== Iterating over a Queue using iterator() ===");
        Iterator<String> iterator = waitingQueue.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.print(name+", ");
        }

        System.out.println("\n\n=== Iterating over a Queue using iterator() and Java 8 forEachRemaining() ===");
        waitingQueue.iterator().forEachRemaining(name -> System.out.print(name+", "));
    }
}
