package com.thumati.java8.concurrency;

import java.util.concurrent.*;

public class FutureCancelExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> future = executorService.submit( ()-> {
            Thread.sleep(2000);
            return "Hello from Callable";
        } );

        while(!future.isDone()){
            System.out.println("Task is still not done...");
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;
            System.out.println("elapsedTimeInSec : "+elapsedTimeInSec);
            if(elapsedTimeInSec > 1){
                System.out.println("Before cancelling task ................");
                future.cancel(true);
            }
        }

        System.out.println("Task completed! Retrieving the result");
        if(!future.isCancelled()) {
            //future.get() method throws CancellationException if the task is already cancelled
            //String result = future.get();
            /*
            The future.get() method blocks and waits for the task to complete. If you call an API from a remote service in the callable task and the remote service is down, then future.get() will block forever, which will make the application unresponsive.

            To guard against this fact, you can add a timeout in the get() method -

            future.get(1, TimeUnit.SECONDS);
            The future.get() method will throw a TimeoutException if the task is not completed within the specified time.
            */
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }else{
            System.out.println("Task Cancelled!");
        }

        executorService.shutdown();
    }
}
