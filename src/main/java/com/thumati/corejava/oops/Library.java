package com.thumati.corejava.oops;

import java.util.List;

/**
 * Java program to illustrate the concept of Composition 
 * Library class contains list of books. 
 */
public class Library {
	
	// reference to refer to list of books. 
	private final List<Book> books;
	
	public Library(List<Book> books) {
		this.books = books;
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
}
