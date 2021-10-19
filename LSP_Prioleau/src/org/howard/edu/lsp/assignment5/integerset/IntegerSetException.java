package org.howard.edu.lsp.assignment5.integerset;

/**
 * Is a exception for when the IntegerSet is the size of 0
 * @author Howard P
 *
 */
public class IntegerSetException extends Exception {  
	private static final long serialVersionUID = 7035980445904148530L;
	public IntegerSetException() {}
	public IntegerSetException(String errorMessage) {  
		super(errorMessage);  
    }  
}  