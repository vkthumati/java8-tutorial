package com.thumati.java8.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceDemo4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {
            try{
                TimeUnit.SECONDS.sleep(10);
                return 1234;
            }catch (InterruptedException e){
                System.out.println("Callable Interrupted Exception : "+e);
                throw new IllegalStateException("Task Interrupted ", e);
            }
            //return 1234;
        };

        Future<Integer> future = executorService.submit(task);

        System.out.println("Future Done ? "+future.isDone());

        try {
            System.out.println("Before Shutdown.............");
            executorService.shutdownNow();
            System.out.println("After Shutdown.............");
            Integer result = future.get();
            System.out.println("Future Done ? "+future.isDone());
            System.out.println("Result : "+result);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException .............. "+e);
            //e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException .............. "+e);
            e.printStackTrace();
        }
        //executorService.shutdown();
    }
}
