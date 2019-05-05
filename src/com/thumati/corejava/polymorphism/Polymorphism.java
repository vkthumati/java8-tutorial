package com.thumati.corejava.polymorphism;

class Parent{
	
	//private methods are not overridden
	private void m1() {
		System.out.println("From Parent's m1()");
	}
	
	// Non-static method which will be overridden in derived class  
	protected void m2() {
		System.out.println("From Parent's m2()");
	}
	
	// Static method in base class which will be hidden in subclass  
	public static void m3() {
		System.out.println("From Parent's m3()");
	}
	
	// Static method in base class which will be hidden in subclass  
	public static void m4() {
		System.out.println("From Parent's m4()");
	}
	
	public void m5() {
		System.out.println("From Parent's m5()");
	}
	
	public void m6() {
		System.out.println("From Parent's m6()");
	}
	
	public void m7() {
		System.out.println("From Parent's m7()");
	}	
}

class Child extends Parent{
	
	//new m1() method
	//unique to Child class
	private void m1() {
		System.out.println("From Child's m1()");
	}
	
	//Overriding method with more accessibility
	@Override
	public void m2() {
		System.out.println("From Child's m2()");
	}
	
	//This method hides m3() from parent.
	public static void m3() {
		System.out.println("From Child's m3()");
	}
	
	/*public void m4() {
		System.out.println("From Child's m4()");
	}
	
	public static void m5() {
		System.out.println("From Child's m5()");
	}*/
	
	@Override
    // no issue while throwing unchecked exception 
	public void m6() throws ArithmeticException{
		System.out.println("From Child's m6()");
	}

	//@Override
    // compile-time error 
    // issue while throwin checked exception 
	/*public void m7() throws Exception{
		System.out.println("From Child's m7()");
	}*/
	
}

class Parent1{ 
    void m1() throws RuntimeException { 
    	System.out.println("From parent m1()");
    } 
} 

class Child1 extends Parent1 { 
    @Override
    // no issue while throwing same exception 
    void m1() throws RuntimeException { 
    	System.out.println("From child1 m1()");
    } 
}

class Child2 extends Parent1 { 
    @Override
    // no issue while throwing subclass exception 
    void m1() throws ArithmeticException { 
    	System.out.println("From child2 m1()");
    } 
}

class Child3 extends Parent1{ 
    @Override
    // no issue while not throwing any exception 
    void m1() { 
    	System.out.println("From child3 m1()");
    } 
}

class Child4 extends Parent1{ 
    //@Override
    // compile-time error 
    // issue while throwing parent exception 
    /*void m1() throws Exception {
    	System.out.println("From child4 m1()");
    } */
} 

public class Polymorphism {

	public static void main(String[] args) {
		 Parent obj1 = new Parent(); 
	     obj1.m2(); 
	     Parent obj2 = new Child(); 
	     obj2.m2(); 
	}

}

