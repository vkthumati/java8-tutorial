package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFuture3 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            //Simulate a long-running job.
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation.";
        };

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);


        // Block and wait for the future to complete
        try {
            String result = completableFuture.get();
            System.out.println("Result : "+result);
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
