package com.thumati.java8.defaultmethods;

public class DefaultMethods {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };

        Formula formulaLambda = a -> {
            //return sqrt(a);
            return Math.sqrt(a);
        };

        System.out.println("Formula static method : "+Formula.add());

    }
}

interface Formula{
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }

    static int add(){
        return 1;
    }
}