package com.thumati.java8.concurrency;

public class ProductService{
    public Product getProductDetails(int id){
        return new Product(id, "InterviewKickstart", 5850);
    }
}