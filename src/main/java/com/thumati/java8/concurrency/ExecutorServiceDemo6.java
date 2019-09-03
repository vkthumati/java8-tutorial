package com.thumati.java8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> tasks =  Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3",
                () -> "task4",
                () -> "task5"
        );

        try {
            executorService.invokeAll(tasks).stream().map( future -> {
                try {
                    return future.get();
                }catch (Exception e){
                    System.out.println("Exception - "+e);
                    throw new IllegalStateException(e);
                }
            }).forEach(System.out::println);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException - "+e);
        }

        executorService.shutdown();
    }
}
