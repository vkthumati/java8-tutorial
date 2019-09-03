package com.thumati.java8.threads;

public class ThreadDemo1 {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("Main Thread");

        Runnable runnable = () -> {
            Thread thumatiThread = Thread.currentThread();
            String currentThreadName = thumatiThread.getName();
            System.out.println("Thumati Thread Details : "+thumatiThread);
            System.out.println("Thumati Thread Name : "+thumatiThread.getName());
        };

        //runnable.run();

        Thread thread = new Thread(runnable, "Thumati Thread");
        thread.start();

        System.out.println("Main Thread Details : "+mainThread);
        System.out.println("Main Thread Name : "+mainThread.getName());
    }
}
