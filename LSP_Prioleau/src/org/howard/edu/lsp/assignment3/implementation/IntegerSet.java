package org.howard.edu.lsp.assignment3.implementation;
import java.util.ArrayList;
/**
 * 
 * @author Howard P
 * @version 1.0
 */
public class IntegerSet{
	// Hint: probably best to use an array list.  You will need to do a little research
	private ArrayList<int> set = new ArrayList<int>();

	// Default Constructor
	public void Set() {
		
	}

	// Clears the internal representation of the set
	public void clear() {
		
	}
	
	/**
	 * Returns the length of the set
	 * 
	 * @return the length of the set
	 */
	public int length(){
		return set.size();
		// returns the length
	}
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * 
	 * @param b is a IntegerSet object
	 * @return the boolean of if the 2 sets are equal to each other
	*/
	public boolean equals(IntegerSet b){
		boolean found = false;
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; i < b.size(); j++) {
				//IF THE VALUE IS FOUND IN THE LIST it WILL make found true
				if (set[i] == b[j]) {
					found = true;
					break;
				}
			}
			//if found it will continue to the next item in the array
			if (found){
				continue;
			}
			//if not found it will break the look and return false
			else {
				return false;
			}
		}
		//Since it was able to run through without breaking means the sets are equal
		return true;
	}
	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value){
		boolean found = false;
		for (int i = 0; i < set.size(); i++) {
			if (set[i] == value) {
				return found;
			}
			return found;
		}
	}
	
	// Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	public int largest(){
		//throws IntegerSetException
	}
	
	// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	public int smallest() {
		//throws IntegerSetException;
	}
	
	// Adds an item to the set or does nothing it already there	
 	public void add(int item) {
 		// adds item to s or does nothing if it is in set
 	}

	// Removes an item from the set or does nothing if not there
	public void remove(int item) {
		//Throws a IntegerSetException of the set is empty
	}
	
	// Set union
	public void union(IntegerSet intSetb){
		
	}
	
	// Set intersection
	public void intersect(IntegerSet intSetb) {
		
	}
	
	// Set difference, i.e., s1 –s2
	public void diff(IntegerSet intSetb){
		// set difference, i.e. s1 - s2
	}
	
	// Returns true if the set is empty, false otherwise
	boolean isEmpty() {
		
	}
	
	// Return String representation of your set
	public String toString(){
		// return String representation of your set
	}	
	}
