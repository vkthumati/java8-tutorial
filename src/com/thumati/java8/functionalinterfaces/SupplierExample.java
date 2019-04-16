package com.thumati.java8.functionalinterfaces;

import com.thumati.java8.lambdaexpressions.Person;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;

        Person person = personSupplier.get();
    }
}
