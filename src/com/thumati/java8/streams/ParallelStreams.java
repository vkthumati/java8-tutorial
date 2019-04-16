package com.thumati.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> list = new ArrayList<>();
        for(int i=0; i<max; ++i){
            list.add(UUID.randomUUID().toString());
        }

        long t1 = System.nanoTime();

        long count = list.stream()
             .sorted()
             .count();
        System.out.println(count);

        long t2 = System.nanoTime();

        long mills = TimeUnit.NANOSECONDS.toMillis(t2-t1);

        System.out.println(String.format("Sequential Sort took : %d ms", mills));

        t1 = System.nanoTime();
        count = list.parallelStream().sorted().count();
        t2 = System.nanoTime();
        mills = TimeUnit.NANOSECONDS.toMillis(t2-t1);
        System.out.println(String.format("Parallel Sort took : %d ms", mills));
    }
}
