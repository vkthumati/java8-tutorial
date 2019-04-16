package com.thumati.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(()->{
            try {
                String threadName = Thread.currentThread().getName();
                for (int i = 0; i < 10; ++i) {
                    System.out.println("Execute " + threadName);
                    TimeUnit.SECONDS.sleep(2);
                }
            }catch (InterruptedException ex){

            }
        });

        executorService.submit( ()-> {
           try {
               String threadName = Thread.currentThread().getName();
               for (int i = 0; i < 10; ++i) {
                   System.out.println("Submit " + threadName);
                   TimeUnit.SECONDS.sleep(2);
               }
           }catch (InterruptedException ex){

           }
        });
}
}
