package com.tutorial.rechner;

import static org.junit.Assert.*;


import org.junit.Test;

import com.tutorial.rechner.Operation;

public class OperationTest {
	
/**
 * checks if calculator could solve operations that include operand with and without comma
 */
	
	@Test
	public void testSimpleOperationWithEvenNumbers() {
		assertResult(115.0, "45 + 88 - 18");
	}
	
	@Test
	public void testSimpleOperationWithEvenNumbersAndComma() {
		assertResult(115.0, "45 + 88.0 - 18");
	}
	
/**
 * checks correct order of execution in operations
 */
	
	@Test
	public void testOperationWithEvenNumbers() {
		assertResult(131.0, "45 + 88 * 1 - 2");
	}
	
	@Test
	public void testBigNumber() {
		assertResult(133.0,"45.0 + 88.0 * 1.0");
	}
	
	@Test
	public void testSimpleMul() {
		assertResult(12.0,"3.0 + 2.0 * 5.0 - 1.0");
	}
	
	@Test
	public void testSimpleDiv() {
		assertResult(2.4,"3.0 + 2.0 / 5.0 - 1.0");
	}		
	
	private void assertResult(Double result, String operation)
	{
		Operation OperationUnderTest = new Operation(operation);
		assertEquals(result, OperationUnderTest.execute(),0);
	}
}
