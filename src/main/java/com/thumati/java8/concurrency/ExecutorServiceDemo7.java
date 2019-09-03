package com.thumati.java8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo7 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> tasks =  Arrays.asList(
                callable("task1", 2),
                callable( "task2", 1),
                callable( "task3", 3)
        );

        try {
            String result = executorService.invokeAny(tasks);
            System.out.println("Result of the First Callable task : "+result);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException - "+e);
        }catch (ExecutionException e) {
            System.out.println("ExecutionException - "+e);
        }

        executorService.shutdown();
    }

    public static Callable<String> callable(String result, long sleepSeconds){
        return () ->{
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
