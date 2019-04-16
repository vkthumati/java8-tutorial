package com.thumati.corejava.lambdaexpressions;

public class LambdaExpressions {

	public static void main(String[] args) {
		//() -> {System.out.println("Hello");};
		() -> System.out.println("Hello");
		(int a, int b) -> {System.out.println(a+b);};
		(a, b) -> {System.out.println(a+b);};
		(a, b) -> System.out.println(a+b);
		(a, b) -> {return a+b;};
		(a, b) -> a+b;
		(a) -> {System.out.println(a);};
		a -> System.out.println(a);
		s -> s.length();
	}

}

@FunctionalInterface
interface MyFunctionalInterface1{
	
	public int add(int a, int b);
	
	//public int sub(int a, int b);
	
	default public void show() {
		System.out.println("Hello");
	}
	
	public static void greetings() {
		System.out.println("Good Morning!");
	}
}

@FunctionalInterface
interface MyFunctionalInterface2{
	
}

@FunctionalInterface
interface MyFuncInterfP{
	public void m1();
}

@FunctionalInterface
interface MyFuncInterfC extends MyFuncInterfP{
	
}

@FunctionalInterface
interface MyFuncInterfC1 extends MyFuncInterfP{
	public void m1();
}

@FunctionalInterface
interface MyFuncInterfC2 extends MyFuncInterfP{
	public void m2();
}


interface MyFuncInterfC3 extends MyFuncInterfP{
	public void m2();
}