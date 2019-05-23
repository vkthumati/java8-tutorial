package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture6 {
    public static void main(String[] args) {
        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> welcomeGreeting = CompletableFuture.supplyAsync( () -> {
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        }).thenApply( (name)->{// Attach a callback to the Future using thenApply()
            String transform = "Hello "+name;
            System.out.println(transform);
            return transform;
        }).thenApply( (greeting)->{// Attach a callback to the Future using thenApply()
            String transform = greeting+", Welcome to the CalliCoder Blog ";
            System.out.println(transform);
            return transform;
        });

        // Block and get the result of the future.
        try {
            System.out.println(welcomeGreeting.get()); // Prints - Hello Rajeev, Welcome to the CalliCoder Blog
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
