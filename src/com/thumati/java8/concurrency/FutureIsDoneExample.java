package com.thumati.java8.concurrency;

import java.util.concurrent.*;

public class FutureIsDoneExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("Entered Callable.");
            Thread.sleep(5000);
            return "Hello, Callable result.";
        };

        Future<String> future = executorService.submit(callable);

        while(!future.isDone()){
            System.out.println("Task is still not done.");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
