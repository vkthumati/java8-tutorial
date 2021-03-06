package com.thumati.corejava.oops;

/**
 * Java program to illustrate the difference between Aggregation Composition. 
 */
final public class Car {
	// For a car to move, it need to have a engine.  
    private final Engine engine; // Composition 
    //private Engine engine;     // Aggregation
    
    public Car(Engine engine) {
    	this.engine=engine;
    }
    
    //car start moving by starting engine
    public void move() {
    	//if(engine!=null)
    	{
    		engine.work();
    		System.out.println("Car is moving");
    	}
    }
}
