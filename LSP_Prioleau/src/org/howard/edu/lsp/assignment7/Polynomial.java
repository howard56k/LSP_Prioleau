package org.howard.edu.lsp.assignment7;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;



/**
 * Create a class to represent a Polynomial in an list of terms.
 * @author Howard P
 * @version 1.0
 */
public class Polynomial {
	private ArrayList<Term> polyList;
	private String headOfList;
	public Polynomial() {
		polyList = new ArrayList<Term>();
	}
	/**
	 * Allows you to read the polynomial by degrees
	 */
	public void parseFileString(String fileLine) throws FileNotFoundException {
		    String data = fileLine.replaceAll("\\r\\n|\\r|\\n", " ");;
		    String[] parts = data.split(";");
		    headOfList = parts[0];
		    for(int i = 1; i < parts.length; i+=2) {
		    	polyList.add(new Term(Integer.parseInt(parts[i]),Integer.parseInt(parts[i+1])));
		    }
		    sortPoly();
	}
	/**
	 * returns polynomial Name
	 * @return the Polynomial Name
	 */
	public String getHeadOfList() {
		return headOfList;
	}
	/**
	 * returns polynomial List
	 * @return the Polynomial List
	 */
	public ArrayList<Term> getPolynomial() {
		return polyList;
	}
	/**
	 * Allows you to Sort the polynomial by degrees
	 */
	public void sortPoly() {
		Collections.sort(polyList, new Comparator<Term>() {
		    @Override
		    public int compare(Term o1, Term o2) {
		        return o1.getExponent().compareTo(o2.getExponent());
		    }
		});
		reverse();
	}
	/**
	 * Allows you to insert coefficient and exponent into the polynomial
	 * @param coefficient
	 * @param exponent
	 */
	public void insert(Integer coefficient, Integer exponent) {
		polyList.add(new Term(coefficient,exponent));
		sortPoly();
	}
	/**
	 * Allows you to delete coefficient and exponent from the polynomial
	 * @param coefficient
	 * @param exponent
	 */
	public void delete(Integer coefficient, Integer exponent) {
		boolean notFound = true;
		for(int i = 0; i < polyList.size(); i++) {
			Term tempTerm = polyList.get(i);
			if((tempTerm.getCoefficient() == coefficient) &&  (tempTerm.getExponent() == exponent)){
				polyList.remove(i);
				notFound = false;
			}
		}
		if(notFound){
			System.out.println("Term provided not found");
		}
	}
	/**
	 * Compares to Polynomials
	 * @param polyb a polynomial object
	 * @return if they are equal
	 */
	public boolean compare(Polynomial polyb) {
		boolean ifEqual = false;
		ArrayList<Term> tempList = new ArrayList<Term>();
		for(int i = 0; i < polyList.size(); i++) {
			for(int x = 0; x < polyb.getPolynomial().size(); x++) {
				if((polyb.getPolynomial().get(x).getCoefficient() == polyList.get(i).getCoefficient())&&(polyb.getPolynomial().get(x).getExponent() == polyList.get(i).getExponent())) {
					tempList.add(polyb.getPolynomial().get(x));
				}
			}
		}
		if ((tempList.size() == polyList.size()) && (tempList.size() == polyb.getPolynomial().size())) {
			ifEqual = true;
		}
		return ifEqual;	
	}
	/**
	 * Allows you to reverse the polynomial
	 */
	public void reverse() {
		ArrayList<Term> revPolyList = new ArrayList<Term>();
		for(int i = polyList.size()-1; i >= 0; i--) {
			revPolyList.add(polyList.get(i));
		}
		polyList = revPolyList;
	}
	/**
	 * returns the polynomial formatted as a string
	 * 
	 * @return polynomial formatted as a string
	 */
	public String toString(){
		String polyNom;
		if(headOfList != null) {
			polyNom = String.format("%s(X) = ",headOfList);
		}
		else {
			polyNom = "";
		}
		for(int i = 0; i < polyList.size(); i++) {
			polyNom += polyList.get(i).toString();
			if(i < polyList.size()-1) {
				polyNom += " + ";
			}
		}
		return polyNom;
	}
	/**
	 * Allows you to multiply 2 Polynomials together
	 * @param polyb is a Polynomial
	 * @return the String of the product value
	 */
	public String product(Polynomial polyb) {
		String productString = "";
		Polynomial productPoly = new Polynomial();
		for(int i = 0; i < polyList.size(); i++) {
			for(int x = 0; x < polyb.getPolynomial().size(); x++) {
				Term temp = polyList.get(i).product(polyb.getPolynomial().get(x));
				productPoly.insert(temp.getCoefficient(), temp.getExponent());
			}
			
		}
		// SIMPLIFIES THE PRODUCT
		Polynomial finProductPoly = new Polynomial();
		ArrayList<Integer> indexToAvoid = new ArrayList<>();
		for(int i = 0; i < productPoly.getPolynomial().size(); i++) {
			boolean foundSame = false;
			for(int x = 0; x < productPoly.getPolynomial().size(); x++) {
				if((x != i) && !(indexToAvoid.contains(x))){	
					if(productPoly.getPolynomial().get(i).getExponent() == productPoly.getPolynomial().get(x).getExponent()) {
						indexToAvoid.add(i);
						indexToAvoid.add(x);
						Integer temp = (productPoly.getPolynomial().get(i).getCoefficient()) + (productPoly.getPolynomial().get(x).getCoefficient());
						finProductPoly.insert(temp, productPoly.getPolynomial().get(i).getExponent());
						foundSame = true;
					}
				}
			}
		}
		for(int i = 0; i < productPoly.getPolynomial().size(); i++) {
			if(!(indexToAvoid.contains(i))){
				finProductPoly.insert(productPoly.getPolynomial().get(i).getCoefficient(), productPoly.getPolynomial().get(i).getExponent());
			}
		}
		productString = finProductPoly.toString();
		return productString;
	}
	
}
