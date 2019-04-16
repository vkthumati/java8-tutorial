package com.thumati.java8.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceDemo5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit( ()->{
            TimeUnit.SECONDS.sleep(3);
            return 1234;
        } );

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException - "+e);
        } catch (ExecutionException e) {
            System.out.println("ExecutionException - "+e);
        } catch (TimeoutException e) {
            System.out.println("TimeoutException - "+e);
        }

        executorService.shutdown();
    }
}
