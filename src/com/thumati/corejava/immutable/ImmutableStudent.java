package com.thumati.corejava.immutable;

public final class ImmutableStudent {
	private final int id;
	private final String name;
	private final Age age;
	
	public ImmutableStudent(int id, String name, Age age) {
		this.id = id;
		this.name = name;
		Age clonedAge = new Age(age.getDay(), age.getMonth(), age.getYear());
		this.age = clonedAge;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Age getAge() {
		return new Age(this.age.getDay(), this.age.getMonth(), this.age.getYear());
	}
	
	public static void main(String[] args) {
		Age age = new Age(28, 05, 1980);
		ImmutableStudent student = new ImmutableStudent(28051980, "Vasanth", age);
		System.out.println("Student age year : "+student.getAge().getYear());
		age.setYear(1979);
		System.out.println("Student age year : "+student.getAge().getYear());
		Age age1 = student.getAge();
		age1.setYear(1982);
		System.out.println("Student age year : "+student.getAge().getYear());
	}
}

class Age{
	private int day;
	private int month;
	private int year;
	
	public Age(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
