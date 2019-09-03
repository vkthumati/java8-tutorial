package com.thumati.java8.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadsReadOnArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i<10; ++i)
            list.add("Hello "+i);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable runnable = () -> {
            for (String s : list) {
                System.out.println(s+" => "+Thread.currentThread());
            }
        };

        for(int i=0; i<10; ++i){
            executorService.submit(runnable);
        }

        executorService.shutdown();
    }
}
