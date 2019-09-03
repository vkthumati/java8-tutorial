package com.thumati.corejava.collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class IterateOverStackExample {
    public static void main(String[] args) {
        Stack<String> stackOfPlates = new Stack<>();

        stackOfPlates.add("Plate 1");
        stackOfPlates.add("Plate 2");
        stackOfPlates.add("Plate 3");
        stackOfPlates.add("Plate 4");

        System.out.println("=== Iterate over a Stack using Java 8 forEach() method ===");
        stackOfPlates.forEach( plate-> System.out.print(plate+", "));

        System.out.println("\n\n=== Iterate over a Stack using Java for-each loop ===");
        for(String plate : stackOfPlates){
            System.out.print(plate+", ");
        }

        System.out.println("\n\n=== Iterate over a Stack using iterator ===");
        Iterator<String> iterator = stackOfPlates.iterator();
        while(iterator.hasNext()){
            String plate = iterator.next();
            System.out.print(plate+", ");
        }

        System.out.println("\n\n=== Iterate over a Stack using iterator() and Java 8 forEachRemaining() method ===");
        stackOfPlates.iterator().forEachRemaining( plate-> System.out.print(plate+", "));

        System.out.println("\n\n=== Iterate over a Stack from TOP to BOTTOM using listIterator() ===");
        // ListIterator allows you to traverse in both forward and backward directions.
        // We'll start from the top of the stack and traverse backwards.
        ListIterator<String> platesListIterator = stackOfPlates.listIterator(stackOfPlates.size());
        while(platesListIterator.hasPrevious())
            System.out.print(platesListIterator.previous()+", ");
    }
}
