package com.thumati.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture7 {
    public static void main(String[] args) {
        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<Void> productFuture = CompletableFuture.supplyAsync( () -> {
            try{
                System.out.println("SupplyAsync Current Thread : "+Thread.currentThread());
                TimeUnit.SECONDS.sleep(2);
                return new ProductService().getProductDetails(1392);
            }catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
        }).thenAccept( (product)->{// Attach a callback to the Future using thenAccept() by passing Consumer
            /*
                Executed in the same thread where the supplyAsync() task is executed
                or in the main thread If the supplyAsync() task completes immediately (Remove sleep() call to verify)
            */
            System.out.println("ThenAccept Current Thread : "+Thread.currentThread());
            System.out.println(product);
        }).thenRun( ()->{// Attach a callback to the Future using thenRun() by passing Runnable
            /*
                Executed in the same thread where the supplyAsync() task is executed
                or in the main thread If the supplyAsync() task completes immediately (Remove sleep() call to verify)
            */
            System.out.println("ThenRun Current Thread : "+Thread.currentThread());
            System.out.println("Getting Product details from ProductService completed");
        });

        try {
            System.out.println("Main Current Thread : "+Thread.currentThread());
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}

class ProductService{
    public Product getProductDetails(int id){
        return new Product(id, "InterviewKickstart", 5850);
    }
}

class Product{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}