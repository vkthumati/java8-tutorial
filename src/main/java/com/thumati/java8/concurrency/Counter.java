package com.thumati.java8.concurrency;

public class Counter {
    int count =0;

    public void increment(){
        count = count + 1;
    }

    public int getCount(){
        return count;
    }
}
