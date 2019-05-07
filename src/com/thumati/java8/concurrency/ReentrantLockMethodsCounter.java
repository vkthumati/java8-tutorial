package com.thumati.java8.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMethodsCounter {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int incrementAndGet(){
        //check if the lock is currently acquired by any thread
        System.out.println("IsLocked : "+lock.isLocked());

        //check if the lock is acquired by the current thread itself.
        System.out.println("IsHeldByCurrentThread : "+lock.isHeldByCurrentThread());

        //Try to acquire the lock
        boolean isAcquired = lock.tryLock();
        //lock.tryLock(1, TimeUnit.SECONDS); //The thread will now pause for one second and wait for the lock to be available. If the lock couldn’t be acquired within 1 second then the thread returns.
        System.out.println("Lock Acquired : "+isAcquired+"\n");

        if(isAcquired){
            try{
                Thread.sleep(2000);
                count = count +1;
            }catch (InterruptedException ex){
                throw new IllegalStateException(ex);
            }finally {
                lock.unlock();
            }
        }
        return count;
    }
}
