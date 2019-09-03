package com.thumati.java8.runtime;

public class ProcessorsAvailable {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("No Of Available processors : "+i);
    }
}
