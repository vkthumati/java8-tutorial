package com.thumati.java8.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int incrementAndGet(){
        return atomicInteger.incrementAndGet();
    }

    public int getCount(){
        return atomicInteger.get();
    }
}
