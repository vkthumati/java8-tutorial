package com.thumati.java8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceInvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(3000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(6000);
            return "Resulkt of Task3";
        };

        List<Callable<String>> callableList = Arrays.asList(task1, task2, task3);
        /*
        Submit multiple tasks and wait for all of them to complete.
        You can execute multiple tasks by passing a collection of Callables to the invokeAll() method. The invokeAll() returns a list of Futures.
        Any call to future.get() will block until all the Futures are complete.*/
        List<Future<String>> futures = executorService.invokeAll(callableList);

        for (Future future:futures) {
            // The result is printed only after all the futures are complete. (i.e. after 6 seconds). the first call to future.get() statement blocks
            // until all the futures are complete. i.e. the results will be printed after 6 seconds.
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
