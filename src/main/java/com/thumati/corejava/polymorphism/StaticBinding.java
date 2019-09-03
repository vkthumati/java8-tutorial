package com.thumati.corejava.polymorphism;

public class StaticBinding {
	
	public static class Superclass{
		
		public static void print() {
			System.out.println("Print in Superclass");
		}
		
	}

	public static class Subclass extends Superclass{

		public static void print() {
			System.out.println("Print in Subclass");
		}
		
	}
	
	public static void main(String[] args) {
		//Superclass A = new Superclass();
		//Superclass B = new Subclass();
		
		Superclass A = null;
		Superclass B = null;
		
		A.print();
		B.print();
	}

}
