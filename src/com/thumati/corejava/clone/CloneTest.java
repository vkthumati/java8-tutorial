package com.thumati.corejava.clone;

public class CloneTest implements Cloneable{
	int x;
	int y;
	TestClone testClone;
	public CloneTest(int x, int y, int a, int b) {
		this.x = x;
		this.y = y;
		this.testClone = new TestClone(a, b);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		CloneTest cloneTest =  (CloneTest)super.clone();
		//cloneTest.testClone = (TestClone)cloneTest.testClone.clone();
		cloneTest.testClone = new TestClone(testClone.a, testClone.b);
		return cloneTest;
	}
	
	@Override
	public String toString() {
		return "X : "+x+" and Y : "+y+testClone;
	}

	public static void main(String[] args) throws Exception{
		CloneTest ct = new CloneTest(10, 20, 30, 40); 
		CloneTest ct1 = (CloneTest)ct.clone();
		
		System.out.println("ct - "+ct);
		System.out.println("\nct1 - "+ct1);
		
		ct1.x=50;
		ct1.y=60;
		ct1.testClone.a=70;
		ct1.testClone.b=80;
		
		System.out.println("\nAfter modifying values in ct1 ...............");
		System.out.println("ct - "+ct);
		System.out.println("\nct1 - "+ct1);
	}

}

class TestClone implements Cloneable{
	int a;
	int b;
	
	public TestClone(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "\nA : "+a+" and B : "+b;
	}
}
