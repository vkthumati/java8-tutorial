package com.thumati.java8.concurrency;

public class MultiThreading {
    public static void main(String[] args) {
        new Thread( ()-> {
           try{
                Thread.sleep(2000);
               System.out.println("Thread1 - After 2 seconds");
           }catch (InterruptedException e){
               System.out.println(e);
           }
        }).start();

        new Thread( ()-> {
            try{
                Thread.sleep(4000);
                System.out.println("Thread2 - After 4 seconds");
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }).start();

        new Thread( ()-> {
            try{
                Thread.sleep(6000);
                System.out.println("Thread3 - After 6 seconds");
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }).start();

        new Thread( ()-> {
            try{
                Thread.sleep(18000);
                System.out.println("Thread4 - After 18 seconds");
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }).start();
    }
}

