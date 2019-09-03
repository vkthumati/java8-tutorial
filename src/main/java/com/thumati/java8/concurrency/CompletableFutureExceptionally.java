package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptionally {
    public static void main(String[] args) {
        int age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 1) {
                throw new IllegalArgumentException("Age can not be negative");
            }

            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).thenApply(type -> type.equalsIgnoreCase("Adult") ? "Adult Type" : "Child Type")
        .thenApply(type -> type.equalsIgnoreCase("Adult Type") ? "Adult Type1" : "Child Type1")
        .exceptionally(ex -> {
            System.out.println("Oops! we have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        try{
            System.out.println(maturityFuture.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
