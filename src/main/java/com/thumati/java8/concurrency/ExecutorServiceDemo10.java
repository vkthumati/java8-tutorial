package com.thumati.java8.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo10 {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling : " + System.nanoTime());
            }catch (InterruptedException e){
                System.out.println("InterruptedException - "+e);
            }
        };

        ScheduledFuture<?> future = executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}
