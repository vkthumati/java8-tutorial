package com.thumati.corejava.lambdaexpressions;

interface MyFunctionalInterf{
	public void m1();
}

interface MyFunctionalInterf1{
	public void add(int a, int b);
}

interface MyFunctionalInterf2{
	public int length(String s);
}

class Demo implements MyFunctionalInterf{
	@Override
	public void m1() {
		System.out.println("m1() method implementation without lambda excpression");
	}
}

class Demo1 implements MyFunctionalInterf1{
	@Override
	public void add(int a, int b) {
		System.out.println("Add a+b : "+ (a+b));
	}
}

class Demo2 implements MyFunctionalInterf2{
	@Override
	public int length(String s) {
		return s.length();
	}
}

public class WithoutAndWithLambda {
	public static void main(String[] args) {
		MyFunctionalInterf i1 = new Demo();
		i1.m1();
		
		MyFunctionalInterf i2 = () -> System.out.println("m1() method implementation without excpression");
		i2.m1();
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i2.getClass().getName());
		System.out.println(i2.getClass().getSimpleName());
		
		MyFunctionalInterf1 i3 = new Demo1();
		i3.add(10 , 20);
		
		MyFunctionalInterf1 i4 = (a, b) -> System.out.println("Add a+b by Lambda : "+ (a+b));
		i4.add(11, 22);
		
		MyFunctionalInterf2 i5 = new Demo2();
		int l1 = i5.length("Vasantha");
		
		MyFunctionalInterf2 i6 = s -> s.length();
		int l2 = i5.length("Vasantha Kumar Thumati");
		
		System.out.println("String length : "+l1);
		System.out.println("String length with lambda expression : "+l2);
	}
}
