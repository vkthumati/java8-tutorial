package com.thumati.java8.methodreferences;

import java.util.Arrays;

public class MethodReferences {
    public static void main(String[] args) {
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
    }
}
