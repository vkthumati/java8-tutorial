package com.thumati.java8.lambdaexpressions;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
