package org.howard.edu.lsp.assignment7;


/**
 * Create a class to represent a term in an algebraic expression.
 * @author Howard P
 * @version 1.0
 */
public class Term {
	private Integer  coeff;
	private Integer  exp;
	
	public Term(Integer  coefficient, Integer exponent) {
		coeff = coefficient;
		exp = exponent;
	}
	
	/**
	 * Returns the Coefficient Value
	 * 
	 * @return Coefficient value
	 */
	public Integer getCoefficient() {
		return coeff;
	}
	/**
	 * Returns the Exponent Value
	 * 
	 * @return exponent Value
	 */
	public Integer getExponent() {
		return exp;
	}
	/**
	 * Returns if 2 terms equal each other
	 * @param b Term object
	 * @return if the terms equals each other
	 */
	public boolean compare(Term b){
		boolean ifEqual = false;
		if((coeff == b.getCoefficient())&&(exp == b.getExponent())) {
			ifEqual = true;
		}
		return ifEqual;
	}
	/**
	 * Returns formated String of the Term
	 * 
	 * @return Term Formatted
	 */
	public String toString() {
		if (exp == 1) {
			return String.valueOf(coeff) + "x";
		}else if(exp != 0){
			return String.valueOf(coeff) + "x^" +String.valueOf(exp);
		}
		else{
			return String.valueOf(coeff);
		}
		
	}
}
