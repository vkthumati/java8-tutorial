package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCompose {
    public static UserService userService = new UserService();
    public static CreditRatingService creditRatingService = new CreditRatingService();

    public static void main(String[] args) {
        CompletableFuture<CompletableFuture<Double>> creditRating = getUserDetails("vthumati").thenApply(user -> getCreditRating(user));
        try {
            System.out.println(creditRating.get().get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

        CompletableFuture<Double> creditRating1 = getUserDetails("vthumati").thenCompose(user -> getCreditRating(user));
        try {
            System.out.println(creditRating1.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }
    }

    public static CompletableFuture<User> getUserDetails(String userId){
        return  CompletableFuture.supplyAsync( ()-> userService.getUserDetails(userId));
    }

    public static CompletableFuture<Double> getCreditRating(User user){
        return CompletableFuture.supplyAsync( ()-> creditRatingService.getCreditRating(user));
    }
}
