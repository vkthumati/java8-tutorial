package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture1 {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        try {
            System.out.println("Before Result  ");
            boolean isCompleted = completableFuture.complete("Default Result ............");
            System.out.println("isCompleted : "+isCompleted);
            String result = completableFuture.get();
            System.out.println("Result : "+result);

            completableFuture.complete("Future's Result");
            System.out.println(completableFuture.get());
            System.out.println(completableFuture.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }


    }
}
