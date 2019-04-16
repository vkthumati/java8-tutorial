package com.thumati.java8.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo9 {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> { System.out.println("Scheduling : "+System.nanoTime()); };

        int initialDelay = 5;
        int period = 1;

        ScheduledFuture<?> future = executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }
}
