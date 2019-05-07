package com.thumati.java8.concurrency;

public class SynchronizedCounter {
    int count =0;

    /*public synchronized void increment(){
        count = count + 1;
    }*/

    public void increment() {
        // Synchronized Block -

        // Acquire Lock
        synchronized (this) {
            count = count + 1;
        }
        // Release Lock
    }

    public int getCount(){
        return count;
    }
}
