package org.howard.edu.lsp.assignment7;

import static org.junit.jupiter.api.Assertions.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PolynomialTest {
	private static HashMap<String, Polynomial> polyMap;
	private static ArrayList<String> listOfOperations = new ArrayList<String>();
	@BeforeAll
    public static void setup() throws FileNotFoundException{
    	String fileName = "./src/org/howard/edu/lsp/assignment7/polyNomialText.txt";
    	File myObj = new File(fileName);
    	Scanner myReader = new Scanner(myObj);
    	polyMap = new HashMap<String, Polynomial>();
    	while (myReader.hasNextLine()) {
    		String nextLine = myReader.nextLine();
    		if (nextLine.contains("(") && nextLine.contains(")")) {
    			listOfOperations.add(nextLine);
    		}else {
    			Polynomial temp = new Polynomial();
    			Polynomial temp2 = new Polynomial();
        		temp.parseFileString(nextLine);
        		temp2.parseFileString(nextLine);
        		String head = temp.getHeadOfList();
        		polyMap.put(temp.getHeadOfList(), temp);
        		polyMap.put(head + ("Clean"), temp2);
        		System.out.println(temp.toString());
    		}
    	}
    	myReader.close();
    }
	@TestFactory
	@Order(1)
	@DisplayName("Test Cases for Insert")
	Iterable<DynamicTest> testInsert(){
		ArrayList<String> insertOperations = new ArrayList<String>();
		for(String operation : listOfOperations) {
			if(operation.contains("insert")){
				insertOperations.add(operation);
			}
		}
		ArrayList<Polynomial> listOfTempPolys = new ArrayList<Polynomial>();
		for(String operation : insertOperations) {
			//PARSE STRING TO GET ONLY THE TERM
			String headOfPoly = operation.split(Pattern.quote("."))[0];
			String[] parts = operation.split("insert")[1].replace("(","").replace(")","").split(",");
			Polynomial temp = polyMap.get(headOfPoly);
			temp.insert(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
			listOfTempPolys.add(temp);
			System.out.println("\nOperation: " +operation + '\n'+ "Result: "+ temp.toString());
		} 
		return Arrays.asList(
				DynamicTest.dynamicTest("Insert to P1",
		        () -> assertEquals(4, listOfTempPolys.get(0).getPolynomial().size())),
				DynamicTest.dynamicTest("Insert to P2",
		        () -> assertEquals(5, listOfTempPolys.get(1).getPolynomial().size())));
	}
	@TestFactory
	@Order(2)
	@DisplayName("Test Cases for Delete")
	Iterable<DynamicTest> testDelete(){
		ArrayList<String> deleteOperations = new ArrayList<String>();
		for(String operation : listOfOperations) {
			if(operation.contains("delete")){
				deleteOperations.add(operation);
			}
		}
		ArrayList<Polynomial> listOfTempPolys = new ArrayList<Polynomial>();
		for(String operation : deleteOperations) {
			//PARSE STRING TO GET ONLY THE TERM
			String headOfPoly = operation.split(Pattern.quote("."))[0];
			String[] parts = operation.split("delete")[1].replace("(","").replace(")","").split(",");
			Polynomial temp = polyMap.get(headOfPoly);
			temp.delete(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
			listOfTempPolys.add(temp);
			System.out.println("Operation: " +operation + '\n'+ "Result: "+ temp.toString() + '\n');
		} 
		return Arrays.asList(
				DynamicTest.dynamicTest("Delete Missing Value from P1",
		        () -> assertEquals(3, listOfTempPolys.get(0).getPolynomial().size())),
				DynamicTest.dynamicTest("Delete Actual Value from P1",
		        () -> assertEquals(3, listOfTempPolys.get(1).getPolynomial().size())),
				DynamicTest.dynamicTest("Delete Actual Value from P2",
		        () -> assertEquals(4, listOfTempPolys.get(2).getPolynomial().size())),
				DynamicTest.dynamicTest("Delete Missing Value from P2",
		        () -> assertEquals(4, listOfTempPolys.get(3).getPolynomial().size())));
	}
	@TestFactory
	@Order(3)
	@DisplayName("Test Cases for Reverse")
	Iterable<DynamicTest> testReverse(){
		ArrayList<String> deleteOperations = new ArrayList<String>();
		for(String operation : listOfOperations) {
			if(operation.contains("reverse")){
				deleteOperations.add(operation);
			}
		}
		ArrayList<Polynomial> listOfTempPolys = new ArrayList<Polynomial>();
		for(String operation : deleteOperations) {
			//PARSE STRING TO GET ONLY THE TERM
			String headOfPoly = operation.split(Pattern.quote("."))[0];
			Polynomial temp = polyMap.get(headOfPoly);
			temp.reverse();
			listOfTempPolys.add(temp);
			System.out.println("\nOperation: " +operation + '\n'+ "Result: "+ temp.toString());
		} 
		return Arrays.asList(
				DynamicTest.dynamicTest("Checks if First Value of Reversed and Last Value of Actual from P1 is the same",
		        () -> assertEquals(true, listOfTempPolys.get(0).getPolynomial().get(0).compare(polyMap.get("P1Clean").getPolynomial().get(2)))),
				DynamicTest.dynamicTest("Checks if First Value of Reversed and Last Value of Actual from P2 is the same",
		        () -> assertEquals(true, listOfTempPolys.get(1).getPolynomial().get(0).compare(polyMap.get("P2Clean").getPolynomial().get(3)))));
	}
}
