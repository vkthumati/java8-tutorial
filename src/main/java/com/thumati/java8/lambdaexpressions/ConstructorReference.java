package com.thumati.java8.lambdaexpressions;

public class ConstructorReference {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;

        Person person = personFactory.create("Vasantha", "Thumati");
        System.out.println("First Name : "+person.firstName);
        System.out.println("Last Name : "+person.lastName);
    }
}
