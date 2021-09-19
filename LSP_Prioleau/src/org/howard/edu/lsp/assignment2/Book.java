package org.howard.edu.lsp.assignment2;

public class Book {
	/**
	 * Creates a book object from title
	 * Book object contains borrwed, returned, isborrowed and getTitle
	 */
	private String title; 
	private boolean borrowed; 

	// Creates a new Book 
	public Book(String bookTitle) { 
		/**
		 * Sets the Book title to the string passed 
		 */
		title = bookTitle;
	} 
	
	public void borrowed() { 
		/**
		 * Marks the book as rented 
		 * Changes the boolean borrowed to true to mean its borrowed 
		 */
		borrowed = true;
	} 
	

	public void returned() { 
		/**
		 * Marks the book as not rented
		 * Changes the boolean borrowed to false to mean its returned 
		 */
		borrowed = false;
	} 
	
	public boolean isBorrowed() { 
		/**
		 * Returns true if the book is rented, false otherwise public 
		 * Returns the status of the book from the boolean borrowed 
		 */
		return borrowed;
	} 

	public String getTitle() { 
		/**
		 * Returns the title of the book public 
		 * Returns the title of the book from the string title 
		 */
		return title;
	}
}
