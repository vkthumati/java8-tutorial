package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture8 {
    public static void main(String[] args) {
        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<Void> welcomeGreeting = CompletableFuture.supplyAsync( () -> {
            try{
                System.out.println("SupplyAsync Current Thread : "+Thread.currentThread());
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        }).thenApplyAsync( (name)->{// Attach a callback to the Future using thenApplyAsync()
            System.out.println("ThenApplyAsync Current Thread : "+Thread.currentThread());
            String transform = "Hello "+name;
            System.out.println(transform);
            try{
                TimeUnit.SECONDS.sleep(8);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return transform;
        }).thenRunAsync( ()->{// Attach a callback to the Future using thenRunAsync()
            // Executed in a different thread from ForkJoinPool.commonPool()
            System.out.println("ThenRunAsync Current Thread : "+Thread.currentThread());
            String transform = "Welcome to the CalliCoder Blog ";
            System.out.println(transform);
        });

        // Block and get the result of the future.
        try {
            System.out.println(welcomeGreeting.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
