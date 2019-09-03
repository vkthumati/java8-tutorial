package com.thumati.java8inaction.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class PartitionPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
        //System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithCustomCollector(100));
    }

    private static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed()
                    .collect(partitioningBy( i ->isPrime(i)));
    }

    private static boolean isPrime(int n){
        return IntStream.rangeClosed(2, n-1)
                .limit((long) Math.floor(Math.sqrt(n)) - 1)
                .noneMatch(i -> n % i == 0);
    }
}
