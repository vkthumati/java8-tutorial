package com.thumati.corejava.polymorphism;

public class DynamicBinding {
	
	public static class Superclass{
		
		public void print() {
			System.out.println("Print in Superclass");
		}
		
	}

	public static class Subclass extends Superclass{

		public void print() {
			System.out.println("Print in Subclass");
		}
		
	}
	
	public class A  {
		private void print() {
			System.out.println("A's print() method has been called");
		}
	}

	public class B extends A {
		public void print() {
			System.out.println("B's print() method has been called");
		}
	}
	
	public class C extends B {
		public void print() {
			System.out.println("C's print() method has been called");
		}
	}
	
	public static void main(String[] args) {
		Superclass A1 = new Superclass();
		Superclass A2 = new Superclass();
		Superclass A3 = new Superclass();
		Superclass A4 = new Superclass();
		
		Superclass B = new Subclass();
		A1.print();
		B.print();
		
		DynamicBinding dynamicBinding = new DynamicBinding();
		
		A a1 = dynamicBinding.new A();
		A a2 = dynamicBinding.new A();
		A a3 = dynamicBinding.new B();
		A a4 = dynamicBinding.new C();
		
		a1.print();
		a2.print();
		a3.print();
		a4.print();
	}

}
