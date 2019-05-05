package com.thumati.java8.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicePractice1 {
    public static void main(String[] args) {
        System.out.println("Inside : "+Thread.currentThread());

        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Runnable and Submit the task specified by the runnable to the executor service...");
        executorService.submit(()-> System.out.println("Inside : "+Thread.currentThread()));

        System.out.println("Shutting down the executor");
        executorService.shutdown();
    }
}
