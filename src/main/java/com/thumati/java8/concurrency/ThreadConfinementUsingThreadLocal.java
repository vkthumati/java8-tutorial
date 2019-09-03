package com.thumati.java8.concurrency;

public class ThreadConfinementUsingThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> stringHolder = new ThreadLocal<>();

        Runnable runnable1 = ()->{
            stringHolder.set("Thread in runnable1");
            try{
                Thread.sleep(5000);
                System.out.println(Thread.currentThread()+" local value "+stringHolder.get());
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
          stringHolder.set("Thread in runnable2");
          try{
              Thread.sleep(2000);
                stringHolder.set("string in runnable2 changed");
              Thread.sleep(2000);
              System.out.println(Thread.currentThread()+" local value "+stringHolder.get());
          }catch (InterruptedException ex){
              ex.printStackTrace();
          }
        };

        Runnable runnable3 = ()->{
            stringHolder.set("Thread in runnable3");
            try{
                Thread.sleep(5000);
                System.out.println(Thread.currentThread()+" local value "+stringHolder.get());
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);

        t1.start();
        t2.start();
        t3.start();

        System.out.println(System.getProperty("user.home"));
    }
}
