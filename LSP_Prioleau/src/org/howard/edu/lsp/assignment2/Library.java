package org.howard.edu.lsp.assignment2;
import java.util.ArrayList;


/**
 * is a library object that has addbook, printopeninghours, printaddress,borrowBook,printAvailableBooks, returnbook
 * Allows to store Book objects and go through them
 * 
 * @author Howard P
 * @version 3.0
 */
public class Library {
	private String address;
	private String openHours = "9am to 5pm";
	private ArrayList<Book> bookCatalog = new ArrayList<Book>();
	
	/**
	 * Creates a library object
	 * 
	 * @param title is a string object that contains the libraries address
	 */
	public Library(String title) {
		address = title;
	}
	
	/**
	 * Adds book to catalog from the book argument passed
	 * 
	 * @param title takes a book object
	 */
	public void addBook(Book title) {
		bookCatalog.add(title);
	}
	
	/**
	 * Prints the opening hours from the string variable openHours
	 */
	public void printOpeningHours() {
		System.out.println("Libraries are open daily from " + openHours + ".");
	}
	
	/**
	 * Prints the address from the string variable address
	 */
	public void printAddress() {
		System.out.println(address);
	}
	
	/**
	 * Allows you to input a title of a book and borrow it
	 * 
	 * searches for the title in the library and if it is found
	 * It will check it out to the user and if not will return that book is not found
	 * 
	 *@param title is a string object of the books title
	 */
	public void borrowBook(String Title) {
		boolean isFound = false;
		for (int i = 0; i < bookCatalog.size(); i++) {
			//CHECKS IF THE BOOK inputed matches the one in the library
		      if (bookCatalog.get(i).getTitle().equals(Title)) {
		    	  //CHecks if the book is borrowed
		    	  if (bookCatalog.get(i).isBorrowed()) {
		    		  System.out.println("Sorry, this book is already borrowed.");
		    		  isFound = true;
		    		  break;
		    	  } else {
		    		  bookCatalog.get(i).borrowed();
		    		  System.out.println("You successfully borrowed " + bookCatalog.get(i).getTitle());
		    		  isFound = true;
			    	  break;
		    	  }
		      }
		}
		if (!isFound){
			System.out.println("Sorry, this book is not in our catalog.");
		}
		
	}
	
	/**
	 * Goes through library list and print the list of available books
	 */
	public void printAvailableBooks() {
		if (bookCatalog.size() == 0){
			System.out.println("No book in catalog ");
		}else {
			//Iterates Through Book Catalog and prints each book
			for (int i = 0; i < bookCatalog.size(); i++) {
					if (!bookCatalog.get(i).isBorrowed()) {
						System.out.println(bookCatalog.get(i).getTitle());
					}
			      
			}
		}
	}
	
	/**
	 * Pass a book title and allows you to return the book to the library
	 * 
	 * @param title is a string object of the books title
	 */
	public void returnBook(String Title) {
		for (int i = 0; i < bookCatalog.size(); i++) {
			//CHECKS IF THE BOOK inputed matches the one in the library
		      if (bookCatalog.get(i).getTitle().equals(Title)) {
		    	  //CHecks if the book is borrowed
		    	  bookCatalog.get(i).returned();
		    	  System.out.println("You successfully returned " + bookCatalog.get(i).getTitle());
		    	  break;
		      }
		}
	}
	
	
	public static void main(String[] args) { 
		// Create two libraries 
		Library firstLibrary = new Library("10 Main St."); 
		Library secondLibrary = new Library("228 Liberty St."); 
	
		// Add four books to the first library 
		firstLibrary.addBook(new Book("The Da Vinci Code")); 
		firstLibrary.addBook(new Book("Le Petit Prince")); 
		firstLibrary.addBook(new Book("A Tale of Two Cities")); 
		firstLibrary.addBook(new Book("The Lord of the Rings")); 
	
		// Print opening hours and the addresses 
		System.out.println("Library hours:");
		firstLibrary.printOpeningHours(); 
		System.out.println(); 
		System.out.println("Library addresses:"); 
		firstLibrary.printAddress(); 
		System.out.println("Library hours:");
		secondLibrary.printOpeningHours(); 
		System.out.println(); 
		System.out.println("Library addresses:"); 
		secondLibrary.printAddress(); 
	
		// Try to borrow The Lords of the Rings from both libraries 
		System.out.println("Borrowing The Lord of the Rings:"); 
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings"); 
		secondLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println(); 
	
		// Print the titles of all available books from both libraries 
		System.out.println("Books available in the first library:"); 
		firstLibrary.printAvailableBooks(); 
		System.out.println(); 
		System.out.println("Books available in the second library:"); 
		secondLibrary.printAvailableBooks(); 
		System.out.println(); 
	
		// Return The Lords of the Rings to the first library 
		System.out.println("Returning The Lord of the Rings:"); 
		firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println(); 
		
		System.out.println("Books available in the first library:"); 
		firstLibrary.printAvailableBooks(); 
		} 
	}