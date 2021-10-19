package org.howard.edu.lsp.assignment5.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.howard.edu.lsp.assignment5.integerset.IntegerSet;
import org.howard.edu.lsp.assignment5.integerset.IntegerSetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


class IntegerSetTest {
	
	
	IntegerSet set1;
	IntegerSet set2;

    @BeforeEach                                         
    void setUp() throws Exception {
    	set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(6);
		
		set2 = new IntegerSet();
		set2.add(7);
		set2.add(5);
		set2.add(4);
		set2.add(6);

    }
	
	@Test                                               
    @DisplayName("Smallest value should work")   
    void testSmallest() throws IntegerSetException {
        assertEquals(1, set1.smallest(),     
                "Smallest value of Set 1 should be 1");  
    }
	
	@Test                                               
    @DisplayName("Largest value should work")   
    void testLargest() throws IntegerSetException {
        assertEquals(7, set2.largest(),     
                "Largest value of Set 2 be 7");  
    }
	@Test                                               
    @DisplayName("Is empty should work")   
    void testIsEmpty() throws IntegerSetException {
        assertEquals(false, set2.isEmpty(),     
                "Is empty should be False");  
    }
}


