package com.thumati.corejava.oops;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookApp {

	public static void main(String[] args) {
		// Creating the Objects of Book class. 
        Book b1 = new Book("EffectiveJ Java", "Joshua Bloch"); 
        Book b2 = new Book("Thinking in Java", "Bruce Eckel"); 
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt"); 
          
        // Creating the list which contains the no. of books. 
        List<Book> books = new ArrayList<Book>(); 
        books.add(b1); 
        books.add(b2); 
        books.add(b3); 
          
        Library library = new Library(books); 
          
        List<Book> bks = library.getBooks(); 
        for(Book bk : bks){ 
            System.out.println("Title : " + bk.getTitle() + " and Author : " + bk.getAuthor()); 
        } 

	}

}
