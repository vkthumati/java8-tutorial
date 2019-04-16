package com.thumati.java8.functionalinterfaces;

import com.thumati.java8.lambdaexpressions.Person;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Person> greter = (p) -> System.out.println("Hello "+p.getFirstName()+" "+p.getLastName());

        greter.accept(new Person("Vasantha", "Thumati"));
    }
}
