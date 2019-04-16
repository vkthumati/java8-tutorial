package com.thumati.corejava.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Author {
	private final String name;
	private final int bornYear;
	private final List<String> works;
	
	public Author(final String name, final int bornYear, final List<String> works) {
		this.name = name;
		this.bornYear = bornYear;
		//this.works = works;
		//this.works = Collections.unmodifiableList(works);
		// Now we make a new List that is a copy of the provided works list
		this.works = Collections.unmodifiableList(new ArrayList<>(works));
	}
	
	public String getName() {
		return this.name;
	}

	public int getBornYear() {
		return this.bornYear;
	}
	
	public List<String> getWorks(){
		return this.works;
	}

	private static void println(final Author author) {
		System.out.println(author.getName() + "was born in " + author.getBornYear() + " and wrote " + author.getWorks().stream().collect(Collectors.joining(",")));
	}
	
	public static void main(String[] args) {
		final List<String> works = Stream.of("Hamlet", "Othello", "Macbeth").collect(Collectors.toList());
		
		final Author author = new Author("William Shakespeare", 1564, works);
		
		println(author);
		
		works.add("Harry Potter");
		
		println(author);
		
		author.getWorks().add("Spider Man");
		
		println(author);
        //System.out.println(author.getName() + " was born in " + author.getBornYear());
	}

}
