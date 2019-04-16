package com.thumati.java8.threads;

import java.util.concurrent.TimeUnit;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Foo : "+name);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bar : "+name);
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
