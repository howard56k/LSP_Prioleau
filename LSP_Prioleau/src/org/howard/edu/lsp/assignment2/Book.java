package org.howard.edu.lsp.assignment2;

public class Book { 
	private String title; 
	private boolean borrowed; 

	// Creates a new Book 
	public Book(String bookTitle) { 
		// Sets the Book title to the string passed 
		title = bookTitle;
	} 
	
	// Marks the book as rented 
	public void borrowed() { 
		// Changes the boolean borrowed to true to mean its borrowed 
		borrowed = true;
	} 
	
	// Marks the book as not rented 
	public void returned() { 
		// Changes the boolean borrowed to false to mean its returned 
		borrowed = false;
	} 
	
	// Returns true if the book is rented, false otherwise public 
	public boolean isBorrowed() { 
		// Returns the status of the book from the boolean borrowed 
		return borrowed;
	} 
	
	// Returns the title of the book public 
	public String getTitle() { 
		// Returns the title of the book from the string title 
		return title;
	}
}
