package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture2 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            //Simulate a long-running job.
            try{
                for(int i=0; i<10; ++i) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Iteration "+i);
                }
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            System.out.println("I'll run in a separate thread than the main thread.");
        };

        // Run a task specified by a Runnable Object asynchronously.
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);


        // Block and wait for the future to complete
        try {
            completableFuture.get();
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
