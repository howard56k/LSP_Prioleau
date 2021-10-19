package org.howard.edu.lsp.assignment3.test;
import org.howard.edu.lsp.assignment3.implementation.IntegerSet;
import org.howard.edu.lsp.assignment3.implementation.IntegerSetException;
/**
 * 
 * @author Howard P
 * @version 1.0
 */
public class Driver {

	/**
	 * @param args
	 * @throws IntegerSetException 
	 */
	public static void main(String[] args) throws IntegerSetException {
		// TODO Auto-generated method stub
		IntegerSet set11 = new IntegerSet();
		IntegerSet set22 = new IntegerSet();
		System.out.println();
		set11 = new IntegerSet();
		set11.add(1);
		set11.add(2);

		set22 = new IntegerSet();
		set22.add(2);
		set22.add(3);

		set11.diff(set22);
		System.out.println(set11.toString());
		
		
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(6);

		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Smallest value in Set1 is: " + set1.smallest());
		System.out.println("Largest value in Set1 is: " + set1.largest());
		System.out.println("Does Set1 contain 5: " + set1.contains(5));
		System.out.println("Length of Set1: " + set1.length());
		set1.remove(6);
		System.out.println("Removing 6 from the set: " + set1.toString());

		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		
		System.out.println("Does Set1 and Set2 equal each other: " + set1.equals(set2));
		System.out.println("Union of Set1 and Set2");
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2: " + set1.toString());
		
		set1.clear();
		System.out.println("Is Set1 empty: " + set1.isEmpty());
		System.out.println("Is Set2 empty: " + set2.isEmpty());
		set2.clear();
		
		set1.add(4);
		set1.add(5);
		set1.add(6);
		
		set2.add(6);
		set2.add(7);
		set2.add(8);
		set2.add(9);
		
		System.out.println("Intersect of Set1 and Set2");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.intersect(set2);
		System.out.println("Result of Intersect of Set1 and Set2: " + set1.toString());
		
		set1.clear();
		set2.clear();
		
		set1.add(9);
		set1.add(10);
		set1.add(11);
		
		set2.add(7);
		set2.add(11);
		set2.add(10);
		set2.add(13);
		
		System.out.println("Difference of Set1 and Set2");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.diff(set2);
		System.out.println("Result of Difference of Set1 and Set2: " + set1.toString());
		
		set1.clear();
		System.out.println("Is Set1 empty: " + set1.isEmpty());
		System.out.println("Largest value in Set1 is: ");
		set1.largest();
		
		

	}

}
