package com.thumati.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantLockMethodsExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ReentrantLockMethodsCounter counter = new ReentrantLockMethodsCounter();

        executorService.submit( () -> {
            System.out.println("IncrementCount (First Thread) : "+counter.incrementAndGet());
        });

        executorService.submit( () -> {
            System.out.println("IncrementCount (Second Thread) : "+counter.incrementAndGet());
        });

        executorService.shutdown();
    }
}
