package org.howard.edu.lsp.assignment5.junit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
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
                "Largest value of Set 2 should be 7");  
    }
	@Test                                               
    @DisplayName("Is empty should work")   
    void testIsEmpty() throws IntegerSetException {
        assertEquals(false, set2.isEmpty(),     
                "Is empty should be False");  
    }
	@Test                                               
    @DisplayName("Length should work")   
    void testLength() throws IntegerSetException {
        assertEquals(4, set2.length(),     
                "Length of set2 should be 4");  
    }
	@Test                                               
    @DisplayName("Equals should work")   
    void testEquals() throws IntegerSetException {
        assertEquals(false, set1.equals(set2),     
                "Set1 shouldnt Equal set2");  
    }
	@Test                                               
    @DisplayName("Contains should work")   
    void testContains() throws IntegerSetException {
        assertEquals(true, set1.contains(3),     
                "Set1 should contain 3");  
    }
	@Test                                               
    @DisplayName("Union should work")   
    void testUnion() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		for(int i = 0; i < set1.length(); i++) {
			temp.add(set1.get(i));
		}
		for(int i = 0; i < set2.length(); i++) {
			temp.add(set2.get(i));
		}
		set1.union(set2);
        assertEquals(true, set1.equals(temp),    
                "Union of Set1 and Set2 should be [1,2,3,6,7,5,4]");  
    }
	@Test                                               
    @DisplayName("Intersect should work")   
    void testIntersect() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		temp.add(6);
		set1.intersect(set2);
        assertEquals(true, set1.equals(temp),    
                "Intersect of Set1 and Set2 should be [6]");  
    }
	@Test                                               
    @DisplayName("Diff should work")   
    void testDiff() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		for(int i = 0; i < set1.length(); i++) {
			temp.add(set1.get(i));
		}
		for(int i = 0; i < set2.length(); i++) {
			if(!(temp.contains(set2.get(i)))){
				temp.add(set2.get(i));
			}else {
				temp.remove(set2.get(i));
			}
		}
		System.out.print(temp.toString());
		set1.diff(set2);
		System.out.print(set1.toString());
        assertEquals(true, set1.equals(temp),    
                "Diff of Set1 and Set2 should be [1,2,3,7,5,4]");  
    }
	/*
	@TestFactory
    Stream<DynamicTest> testDifferent() {
        MyClass tester = new MyClass();
        int[][] data = new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, tester.multiply(m1, m2));
            });
        });
    }
    */
	
}


