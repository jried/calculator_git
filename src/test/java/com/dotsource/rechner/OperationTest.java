package com.dotsource.rechner;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testCOmplexOperationWithoutBracesAddition() {
		assertResult(14.0,"2 + 4 + 3 + 5");
	}
	
	@Test
	public void testComplexOperationWithoutBracesSubtraction() {
		assertResult(4.0,"2 + 1 + 4 - 3");
	}
	
	@Test
	public void testComplexOperationWithOrderOfOperation() {
		assertResult(22.0,"2 + 4 + 2 - 2 + 4 * 4");
	}


	@Test
	public void testComplexOperationWithBracers() {
		assertResult(8.0,"2 + 4 + 2 - (2 + 2) + 2");
	}

	
	@Test
	public void testRandom() {
		Double r1 = Math.random() * 4;
		Double r2 = Math.random() * 6;
		assertResult(r1+r2,r1+" + "+r2);
	}
		
	
	private void assertResult(Double result, String operation)
	{
		Operation OperationUnderTest = new Operation(operation);
		assertEquals(result, OperationUnderTest.execute(),0);
	}
	

}
