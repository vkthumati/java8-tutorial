package com.thumati.corejava.lambdaexpressions;

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			System.out.println("Child thread - "+i);
		}
	}
}

public class ThreadsWithLambdaExpressions {
	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable);
		t1.start();
		for(int i=0; i<10; ++i) {
			System.out.println("Main thread executed - "+i);
		}
		
		Runnable runnable1 = () -> { for(int i=0; i<10; ++i) { System.out.println("Child thread by Lambda : "+i); } };
		Thread t2 = new Thread(runnable1);
		t2.start();
	}
}
