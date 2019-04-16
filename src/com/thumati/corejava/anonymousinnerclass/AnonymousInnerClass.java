package com.thumati.corejava.anonymousinnerclass;

interface Interf{
	public void m1();
}

public class AnonymousInnerClass {

	int x = 888;
	int y = 777;
	public void m2() {
		
		final int a =10;
		
		System.out.println(this.x);
		
		Interf i = new Interf() {
			int x = 999;
			
			@Override
			public void m1() {
				System.out.println(this.x);
				System.out.println(AnonymousInnerClass.this.y);
				System.out.println(AnonymousInnerClass.this.x);
			}
		};
		i.m1();
		
		Interf i1 = new Interf() {
			int x = 999;
			
			@Override
			public void m1() {
				System.out.println(this.x);
				System.out.println(AnonymousInnerClass.this.y);
				System.out.println(AnonymousInnerClass.this.x);
			}
		};
		i1.m1();
		
		Interf i2 = () -> {
			int x = 111;
			int y = 222;
			System.out.println("Lambda - x : "+x);
			System.out.println("Lambda - y : "+y);
			System.out.println("Lambda - x : "+this.x);
			System.out.println("Lambda - y : "+this.y);
			System.out.println("lambda - a : "+a);
			
		};
		i2.m1();
		
		x = 999;
		y = 888;
		a = 20;
	}
	
	public static void main(String[] args) {
		AnonymousInnerClass inner = new AnonymousInnerClass();
		inner.m2();
	}
}
