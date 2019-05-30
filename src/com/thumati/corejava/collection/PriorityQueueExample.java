package com.thumati.corejava.collection;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> integersPriorityQueue = new PriorityQueue<>();
        integersPriorityQueue.add(750);
        integersPriorityQueue.add(100);
        integersPriorityQueue.add(500);
        integersPriorityQueue.add(900);
        integersPriorityQueue.add(50);
        while(!integersPriorityQueue.isEmpty())
            System.out.print(integersPriorityQueue.remove()+" ");

        System.out.println();
        PriorityQueue<String> stringsPriorityQueue = new PriorityQueue<>();
        stringsPriorityQueue.add("Vasanth");
        stringsPriorityQueue.add("Thumati");
        stringsPriorityQueue.add("Sujatha");
        stringsPriorityQueue.add("Deepika");
        stringsPriorityQueue.add("Yashitha");
        while(!stringsPriorityQueue.isEmpty())
            System.out.print(stringsPriorityQueue.remove()+" ");

    }
}
