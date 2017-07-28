package com.tutorial.rechner;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.tutorial.rechner.Operation;

/**
 * Start of Operations that include bracket terms
 */

public class OperationWithBraces {
	
	@Test
	public void testSimple() {
		assertResult(5.0,"(3.0 + 2)");
	}	
	
	@Test
	public void testSimpleBracesMinus() {
		assertResult(8.4,"(3.0 + 3) + 3.0 + 2.0 / 5.0 - 1.0");
	}	
	
	@Test
	public void testSimpleBracesPlus() {
		assertResult(10.4,"(3.0 + 3) + 3.0 + 2.0 / 5.0 + 1.0");
	}
	
	@Test
	public void testTwoBraces() {
		assertResult(3.0,"(5 + 2.0) - (3.0 + 1)");
	}
	
	@Test
	public void testIntricatedBracesPlus() {
		assertResult(9.0,"(8 + (4 - 3.0))");
	}
	
	@Test
	public void testIntricatedBracesMul() {
		assertResult(8.0,"(8 * (4 - 3.0))");
	}
	
	@Test
	public void testIntricatedBracesMulAndPlus() {
		assertResult(10.0,"(8 * (4 - 3.0)) + 2.0");
	}
	
	@Test
	public void testIntricatedBracesAllOperations() {
		assertResult(7.0,"(8 * (4 - 3.0)) + 2.0 - (9.0 / (2 + 1.0))");
	}
	
	@Test
	public void testThreeIntricatedBracesAllOperations() {
		assertResult(4.0,"((8 * (4 - 3.0)) + 2.0 - (9.0 / (2 + 1.0)) + 1) / 2.0");
	}
	
	@Test
	public void testThreeIntricatedBracesAllOperationsNegativeOperands() {
		assertResult(2.0,"((8 * (4 - 3.0)) + -2.0 - (9.0 / (2 + 1.0)) + 1) / 2.0");
	}
	
	private void assertResult(Double result, String operation)
	{
		Operation OperationUnderTest = new Operation(operation);
		assertEquals(result, OperationUnderTest.execute(),0);
	}
}
