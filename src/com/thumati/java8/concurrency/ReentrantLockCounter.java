package com.thumati.java8.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    private final ReentrantLock reentrantLock = new ReentrantLock();

    private int count = 0;

    //Thread safe increment
    public void increment(){
        reentrantLock.lock();
        try{
            count = count+1;
        }finally {
            reentrantLock.unlock();
        }
    }
}
