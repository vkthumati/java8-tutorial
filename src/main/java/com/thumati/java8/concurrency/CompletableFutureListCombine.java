package com.thumati.java8.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureListCombine {

    public static void main(String[] args) {
        /*List<String> webPageLinks = new ArrayList<>();
        for(int i=0; i<10; ++i)
            webPageLinks.add("WebPageLink"+i);*/

        List<String> webPageLinks = IntStream.rangeClosed(1, 40).mapToObj(i -> "WebPageLink" + i).collect(Collectors.toList());

        // Download contents of all the web pages asynchronously
        List<CompletableFuture<String>> pageContentFutures = webPageLinks.
                                                                    stream().
                                                                    map(webPageLink -> downloadPageContent(webPageLink)).
                                                                    collect(Collectors.toList());

        // Create a combined Future using allOf()
        //CompletableFuture.allOf(completableFutureList.stream().toArray( n -> new CompletableFuture[n]));
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(pageContentFutures.stream().
                toArray(CompletableFuture[]::new));

        System.out.println("All Futures are completed");

        // When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply( v -> pageContentFutures.
                                                                                        stream().
                                                                                        map( pageContentFuture -> pageContentFuture.join() ).
                                                                                        collect(Collectors.toList()));

        // Count the number of web pages having the "CompletableFuture" keyword.
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents ->
                pageContents.stream().filter(pageContent -> pageContent.contains("CompletableFuture")).count());

        try {
            System.out.println("Number of Web Pages having CompletableFuture keyword - " + countFuture.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }

    }

    public static CompletableFuture<String> downloadPageContent(String webPageLink){
        return CompletableFuture.supplyAsync( ()-> {
            String pageContent = webPageLink+" CompletableFuture Content";
            System.out.println(pageContent +" ->"+Thread.currentThread());
            return pageContent;
        });
    }
}
