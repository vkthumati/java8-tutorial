package com.thumati.corejava.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Queue in Java is just an interface. We need a concrete implementation of the Queue interface to work with, in our programs.
 *
 * The LinkedList class implements the Queue interface and therefore it can be used as a Queue.
 */
public class QueueExample {

    public static void main(String[] args) {
        // Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();

        // Adding new elements to the Queue (The Enqueue operation)
        waitingQueue.add("Rajeev");
        waitingQueue.add("Chris");
        waitingQueue.add("John");
        waitingQueue.add("Mark");
        waitingQueue.add("Steven");

        System.out.println("WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using remove() (The Dequeue operation)
        // The remove() method throws NoSuchElementException if the Queue is empty
        String name = waitingQueue.remove();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using poll()
        // The poll() method is similar to remove() except that it returns null if the Queue is empty.
        name = waitingQueue.poll();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

    }

}
