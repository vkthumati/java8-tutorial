package com.thumati.java8inaction.chap03;

import java.util.function.Function;

public class ComposeFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x+1;
        Function<Integer, Integer> g = x -> x*2;

        Function<Integer, Integer> h = f.andThen(g);

        int result = h.apply(1);
        System.out.println("andThen : "+result);

        Function<Integer, Integer> i = f.compose(g);
        result = i.apply(1);
        System.out.println("compose : "+result);

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);

        System.out.println("transformationPipeline : "+transformationPipeline.apply("Hello Vasant : "));
    }
}
