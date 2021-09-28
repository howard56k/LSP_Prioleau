package org.howard.edu.lsp.assignment2;

/**
 * is a book object from title
 * Book object contains methods borrowed, returned, isborrowed and getTitle
 * 
 * @author Howard P
 * @version 3.0
 */
public class Book {
	private String title; 
	private boolean borrowed; 
	
	/**
	 * Creates a book object
	 * 
	 * @param bookTitle is a string object that contains the book's title
	 */
	public Book(String bookTitle) { 
		title = bookTitle;
	} 
	
	/**
	 * Marks the book as rented 
	 * 
	 * Changes the boolean borrowed to true to mean its borrowed 
	 * 
	 */
	public void borrowed() { 
		borrowed = true;
	} 
	
	/**
	 * Marks the book as not rented
	 * 
	 * Changes the boolean borrowed to false to mean its returned 
	 */
	public void returned() { 
		borrowed = false;
	} 
	
	/**
	 * Returns true if the book is rented, false otherwise public
	 *  
	 * @return the status of the book from the boolean borrowed 
	 */
	public boolean isBorrowed() { 
		return borrowed;
	} 
	
	/**
	 * Returns the title of the book public 
	 * 
	 * @return the title of the book from the string title 
	 */
	public String getTitle() { 
		return title;
	}
}
