package org.howard.edu.lsp.assignment5.junit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
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
	@TestFactory
	@DisplayName("Test Cases for Smallest")    
	Iterable<DynamicTest> testSmallest() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			temp.smallest();
	    });
	    String expectedMessage = "The IntegerSet is empty";
	    String actualMessage = exception.getMessage();
		return Arrays.asList(
				DynamicTest.dynamicTest("Filled Smallest test",
		        () -> assertEquals(1, set1.smallest())),
				DynamicTest.dynamicTest("Empty Smallest Test",
		        () -> assertTrue(actualMessage.contains(expectedMessage) )));
	}
	@TestFactory
	@DisplayName("Test Cases for Largest")   
	Iterable<DynamicTest> testLargest() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			temp.largest();
	    });
	    String expectedMessage = "The IntegerSet is empty";
	    String actualMessage = exception.getMessage();
		return Arrays.asList(
				DynamicTest.dynamicTest("Filled Largest test",
		        () -> assertEquals(7, set2.largest())),
				DynamicTest.dynamicTest("Empty Largest Test",
		        () -> assertTrue(actualMessage.contains(expectedMessage) )));
	}
	@TestFactory
	@DisplayName("Test Cases for Empty and Clear")  
	Iterable<DynamicTest> testEmptyandClear() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		set1.clear();
		return Arrays.asList(
				DynamicTest.dynamicTest("True Empty test",
		        () -> assertEquals(true, temp.isEmpty())),
				DynamicTest.dynamicTest("False Empty test",
				() -> assertEquals(false, set2.isEmpty())),
				DynamicTest.dynamicTest("Clear Test",
		        () -> assertEquals(0, set1.length())));
	}
	@Test                                               
    @DisplayName("Test Case for Length")   
    void testLength() throws IntegerSetException {
        assertEquals(4, set2.length(),     
                "Length of set2 should be 4");  
    }
	@TestFactory
	@DisplayName("Test Cases for Equals")
	Iterable<DynamicTest> testEquals() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		return Arrays.asList(
				DynamicTest.dynamicTest("True Equal test",
		        () -> assertEquals(true, set1.equals(set1))),
				DynamicTest.dynamicTest("False Equal Test",
		        () -> assertEquals(false, set2.equals(temp))));
	}
	@TestFactory
	@DisplayName("Test Cases for Contains") 
	Iterable<DynamicTest> testContains() throws IntegerSetException {
		return Arrays.asList(
				DynamicTest.dynamicTest("True Contains test",
		        () -> assertEquals(true, set1.contains(3))),
				DynamicTest.dynamicTest("False Contains Test",
		        () -> assertEquals(false, set1.contains(11))));
	}
	@Test                                               
    @DisplayName("Test Case for Union")   
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
    @DisplayName("Test Case for Intersect")   
    void testIntersect() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		temp.add(6);
		set1.intersect(set2);
        assertEquals(true, set1.equals(temp),    
                "Intersect of Set1 and Set2 should be [6]");  
    }
	@Test                                               
    @DisplayName("Test Case for Diff")   
    void testDiff() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		for(int i = 0; i < set1.length(); i++){
			temp.add(set1.get(i));
		}
		for(int i = 0; i < set2.length(); i++){
			if(!(temp.contains(set2.get(i)))){
				temp.add(set2.get(i));
			}else {
				temp.remove(set2.get(i));
			}
		}
		set1.diff(set2);
        assertEquals(true, temp.equals(set1),    
                "Diff of Set1 and Set2 should be [1,2,3,7,5,4]");  
    }
	@TestFactory
	@DisplayName("Test Cases for Add and Remove") 
	Iterable<DynamicTest> testAddandRemove() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		//CREATES LIST THAT IS THE LAST ITEM SHORT OF SET1
		for(int i = 0; i < set1.length()-1; i++) {
			temp.add(set1.get(i));
		}
		set1.remove(6);
		set2.add(10);
		return Arrays.asList(
				DynamicTest.dynamicTest("Remove test",
		        () -> assertEquals(true, set1.equals(temp))),
				DynamicTest.dynamicTest("Add Test",
		        () -> assertEquals(5, set2.length())));
	}
	@TestFactory
	@DisplayName("Test Cases for toString") 
	Iterable<DynamicTest> testToString() throws IntegerSetException {
		IntegerSet temp = new IntegerSet();
		String set1String = set1.toString();
		
		boolean correctString = true;
		for(int i = 0; i < set1.length(); i++) {
			//CHECKS IF STRING CONTAINS EACH NUMBER IN THE LIST
			if (!(set1String.contains(set1.get(i).toString()))){
				correctString = false;
			}
		}
		//SETS THE BOOLEAN AS FINAL VALUE SO THE TEST WOULD ACCEPT IT
		final boolean correctString1 = correctString;
		return Arrays.asList(
				DynamicTest.dynamicTest("Empty ToString test",
		        () -> assertEquals("Set is Empty", temp.toString())),
				DynamicTest.dynamicTest("Filled Set ToString Test",
		        () -> assertEquals(true, correctString1)));
	}
}


