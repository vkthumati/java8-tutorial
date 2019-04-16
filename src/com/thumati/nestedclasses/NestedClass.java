package com.thumati.nestedclasses;

public class NestedClass {

	int x;
	static int y;
	
	static void staticMethod() {
		System.out.println("Static method in Outer/Enclosing class");
	}
	
	void instanceMthod() {
		System.out.println("Instance method in Outer/Enclosing class");
	}
	
	static class StaticNestedClass{
		int i;
		static int j;
		
		StaticNestedClass() {
			this.i=10;
		}
		
		static void staticNestedMethod() {
			staticMethod();
			System.out.println("Static method in StaticNestedClass class");
		}
		
		void instanceNestedMthod() {
			i =20;
			j = 30;
			staticMethod();
			staticNestedMethod();
			System.out.println("Instance method in StaticNestedClass class");
		}
	}
	
	//Non-Static Nested class or Inner Class
	class InnerClass{
		int p;
		
		InnerClass(){
			this.p=5;
		}
		
		void instanceInnerMethod() {
			x = 100;
			y = 200;
			staticMethod();
			instanceMthod();
		}
	}
	
	public static void main(String[] args) {
		
		StaticNestedClass staticNestedClass = new StaticNestedClass();
		staticNestedClass.instanceNestedMthod();
		staticNestedClass.staticNestedMethod();
		StaticNestedClass.staticNestedMethod();
		
		NestedClass enclosingObj = new NestedClass();
		InnerClass innerClass = enclosingObj.new InnerClass();
		
	}
}
