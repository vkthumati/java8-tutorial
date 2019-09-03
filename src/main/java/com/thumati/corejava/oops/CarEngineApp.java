package com.thumati.corejava.oops;

public class CarEngineApp {
	public static void main(String[] args) {
		// making an engine by creating an instance of Engine class. 
        Engine engine = new Engine(); 
          
        // Making a car with engine. so we are passing a engine instance as an argument while creating instance of Car. 
        Car car = new Car(engine); 
        car.move(); 
	}
}
