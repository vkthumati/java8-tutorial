package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureThenCombine {
    public static void main(String[] args) {

        System.out.println("Retrieving weight.");
        CompletableFuture<Double> weightInKgsFuture = CompletableFuture.supplyAsync( ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println("weightInKgsFuture : "+e);
            }
            return 65.4;
        });

        System.out.println("Retrieving height.");
        CompletableFuture<Double> heightInCmsFuture = CompletableFuture.supplyAsync( ()-> {
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println("heightInCmsFuture : "+e);
            }
            return 177.8;
        });

        System.out.println("Calculating BMI.");
        CompletableFuture<Double> combinedFuture = weightInKgsFuture.
                thenCombine(heightInCmsFuture, (weightInKgs, heightInCms) -> {
            Double heightInMeter = heightInCms / 100;
            return weightInKgs / (heightInMeter * heightInMeter);
        });

        try {
            System.out.println("Your BMI is - " + combinedFuture.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }
    }
}
