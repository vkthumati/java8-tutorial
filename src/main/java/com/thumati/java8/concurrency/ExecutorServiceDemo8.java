package com.thumati.java8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo8 {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable runnable = () -> { System.out.println("Scheduling : "+System.nanoTime()); };

        ScheduledFuture<?> future = executor.schedule(runnable, 5, TimeUnit.SECONDS);

        try {
            TimeUnit.MICROSECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay :%sms",remainingDelay);
        executor.shutdown();
    }
}
