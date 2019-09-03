package com.thumati.java8.functionalinterfaces;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));

        optional.ifPresent( s -> System.out.println(s.charAt(0)));
    }
}
