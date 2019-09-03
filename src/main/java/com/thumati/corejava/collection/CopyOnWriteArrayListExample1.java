package com.thumati.corejava.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i=0; i<10; ++i){
            copyOnWriteArrayList.add("Vasanth"+i);
        }

        for(String s :copyOnWriteArrayList){
            System.out.println(s);
            copyOnWriteArrayList.add(s);
        }

        System.out.println("\n==================================");
        for(String s :copyOnWriteArrayList){
            System.out.println(s);
        }
    }
}
