package com.thumati.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(()->{
            try {
                String threadName = Thread.currentThread().getName();
                for (int i = 0; i < 10; ++i) {
                    System.out.println("Execute " + threadName);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException ex){

            }
        });

        executorService.submit( ()-> {
           try {
               String threadName = Thread.currentThread().getName();
               for (int i = 0; i < 10; ++i) {
                   System.out.println("Submit " + threadName);
                   TimeUnit.SECONDS.sleep(1);
               }
           }catch (InterruptedException ex){

           }
        });

        executorService.shutdown();

       /* try {
            System.out.println("Attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            System.out.println("Tasks are interrupted ");
        }finally {
            if (!executorService.isTerminated()){
                System.out.println("Cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("Shutdown finished");
        }*/
    }
}
