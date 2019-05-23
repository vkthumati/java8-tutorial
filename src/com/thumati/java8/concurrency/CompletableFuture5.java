package com.thumati.java8.concurrency;

import java.util.concurrent.*;

public class CompletableFuture5 {
    public static void main(String[] args) {
        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync( () -> {
            try{
                System.out.println("A long-running task");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("After 10 seconds");
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        // Attach a callback to the Future using thenApply()
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply( (name)->{
            String transform = "Hello "+name;
            System.out.println(transform);
            return transform;
        } );

        /*try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            System.out.println(e);
        }*/

        // Block and get the result of the future.
        try {
            System.out.println(greetingFuture.get()); // Hello Rajeev
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
