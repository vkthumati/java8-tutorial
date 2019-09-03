package com.thumati.java8.concurrency;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFuture4 {
    public static void main(String[] args) {

        Executor executor = Executors.newFixedThreadPool(10);

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync( () -> {
            //Simulate a long-running job.
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation.";
        }, executor);


        // Run a task specified by a Runnable object asynchronously
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync( () -> {
            //Simulate a long-running job.
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            System.out.println("Result of the asynchronous computation.");
        }, executor );
    }
}
