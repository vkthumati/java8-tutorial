package com.thumati.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(()->{
            String threadName = Thread.currentThread().getName();
            try {
                for (int i = 0; i < 10; ++i) {
                    System.out.printf("\nExecute %d %s",i,threadName);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException ex){
                System.out.printf("\nExecute %s : %s",threadName,ex.getMessage());
            }
        });

        executorService.submit( ()-> {
            String threadName = Thread.currentThread().getName();
           try {
               for (int i = 0; i < 10; ++i) {
                   System.out.printf("\nSubmit %d %s",i,threadName);
                   TimeUnit.SECONDS.sleep(1);
               }
           }catch (InterruptedException ex){
               System.out.printf("\nSubmit %s : %s",threadName,ex.getMessage());
           }
        });
        try {
            System.out.println("\nAttempt to shutdown executor");
            //executorService.shutdown();
            executorService.shutdownNow();
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            System.out.println("\nTasks are interrupted ");
        }finally {
            if (!executorService.isTerminated()){
                System.out.println("\nCancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("\nShutdown finished");
        }
    }
}
