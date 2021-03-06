package org.howard.edu.lsp.assignment3.implementation;
import java.util.ArrayList;


/**
 * Creates a IntergerSet object that is based on a Arraylist
 * @author Howard P
 * @version 1.0
 */
public class IntegerSet{
	// Hint: probably best to use an array list.  You will need to do a little research
	private ArrayList<Integer> set = new ArrayList<Integer>();


	/**
	 * Default Constructor
	 */
	public void Set() {
	}

	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		set = new ArrayList<Integer>();
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
			if(b.contains(set.get(i))){
				found = true;
				break;
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

	/**
	 * Returns true if the set contains the value, otherwise false
	 * 
	 * @param value is a int object that you want to see if the set contains
	 * @return a boolean if the set has the value given
	 */
	public boolean contains(int value){
		return set.contains(set.indexOf(value));
	}
	
	/**
	 * Returns the largest item in the set 
	 * Throws a IntegerSetException if the set is empty 
	 * 
	 * @return the largest value in the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws IntegerSetException{
		if (set.size() == 0) {
			throw new IntegerSetException("The IntegerSet is empty");
		}
		int largVal = set.get(0);
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) > largVal) {
				largVal = set.get(i);
			}
		}
		return largVal;
	}
	
	/**
	 *Returns the smallest item in the set
	 *Throws a IntegerSetException if the set is empty
	 *
	 * @return the smallest item in the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("The IntegerSet is empty");
		}
		int smallVal = set.get(0);
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) < smallVal) {
				smallVal = set.get(i);
			}
		}
		return smallVal;
	}
	
	/**
	 * Adds an item to the set or does nothing it already there
	 * 
	 * 
	 * @param item is a int object that you want added to the set
	 */
 	public void add(int item) {
 		if(!(set.contains(item))){
 			set.add(item);
		}
 	}
 	
 	/**
	 * Returns an Item from set by index
	 * 
	 * 
	 * @param index is a int object that you returned
 	 * @return 
	 */
 	public Integer get(int index) {
 		return set.get(index);
 	}

 	/**
 	 * Removes an item from the set or does nothing if not there
 	 * Throws a IntegerSetException if the set is empty
 	 * 
 	 * @param item is a int object that you want removed to the set
 	 * @throws IntegerSetException if the set is empty
 	 */
	public void remove(int item) throws IntegerSetException{
		if (set.indexOf(item) != -1) {
			set.remove(set.indexOf(item));
		}
		
	}
	
	/**
	 * Set union
	 * Combines 2 integerSets
	 * 
	 * @param intSetb is a integerSet object
	 */
	public void union(IntegerSet intSetb){
		for(int i = 0; i < set.size(); i++) {
			intSetb.add(set.get(i));
		}
		set = intSetb.getArrayList();
	}
	

	/**
	 * Creates a new set of the intersection of both objects
	 * 
	 * @param intSetb is a IntergerSet object you want to be intersected with the set
	 */
	public void intersect(IntegerSet intSetb) {
		ArrayList<Integer> set2 = new ArrayList<Integer>();
		for (int i = 0; i < set.size(); i++) {
			if(intSetb.contains(set.get(i))){
				set2.add(set.get(i));
			}
		}
		set = set2;
	}
	
	/**
	 * Creates a new set from the difference of both objects
	 * 
	 * @param intSetb is a IntergerSet object you want to be difference with the set
	 * @throws IntegerSetException 
	 */
	public void diff(IntegerSet intSetb) throws IntegerSetException{
		ArrayList<Integer> set2 = new ArrayList<Integer>();
		ArrayList<Integer> intSetBList = intSetb.getArrayList();
		for (int i = 0; i < intSetBList.size(); i++) {
			if(set.contains(intSetBList.get(i))) {
				set.remove(set.indexOf(intSetBList.get(i)));
			} else {
				set.add(intSetBList.get(i));
			}
			
		}
	}
	
	/**
	 * Returns the ArrayList of the IntergerSet Object
	 * 
	 * @return the ArrayList of the IntergerSet Object
	 */
	public ArrayList getArrayList() {
		return set;
	}

	/**
	 * Returns true if the set is empty, false otherwise
	 * 
	 * @return boolean whether the set is empty or not
	 */
	public boolean isEmpty() {
		if (set.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	

	/**
	 * Creates a String representation of your set
	 * 
	 * @return The String Representation of my set
	 */
	public String toString(){
		// return String representation of your set
		String setString = "[ ";
		for (int i = 0; i < set.size() - 1 ; i++) {
			setString += String.valueOf(set.get(i)) + " , ";
		}
		if (set.size() == 0) {
			return "Set is Empty";
		}
		else {
			return setString += String.valueOf(set.get((set.size() - 1))) + " ]";
		}
		
		
	}

}


