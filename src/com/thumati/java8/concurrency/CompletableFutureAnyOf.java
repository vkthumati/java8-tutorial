package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureAnyOf {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("Result of Future1");
            return "Result of Future1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("Result of Future2");
            return "Result of Future2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("Result of Future3");
            return "Result of Future3";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        try{
            Object o = anyOfFuture.get();
            System.out.println(o);
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }
}
