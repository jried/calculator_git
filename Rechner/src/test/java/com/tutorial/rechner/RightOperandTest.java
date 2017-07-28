package com.tutorial.rechner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tutorial.rechner.Operation;

public class RightOperandTest {

	Operation OperationUnderTest = new Operation("");	
	
/**
 * Start of testing rightOperand method of Operation class
 */
	
	@Test
	public void rightOperandTest() {
		String operationPart = "5.78 + 18.0";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +18.0, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void rightOperandNegativTest() {
		String operationPart = "5.0 + -18.0";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" + -18.0, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void rightOperandNegativExtendedTest() {
		String operationPart = "5.0 + -18.0";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +-18.0, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void rightOperandAsIntTest() {
		String operationPart = "5.0 + 18";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +18, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void negativeRightOperandAsIntTest() {
		String operationPart = "5.0 + -18";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +-18, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void oddRightOperand() {
		String operationPart = "0.03 + 0.0097";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +0.0097, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
	
	@Test
	public void testWithNegativeThirdOperand() {
		String operationPart = "1.0 + 4.0 + -7";
		int indexOfOperation = operationPart.indexOf("+");
		
		assertEquals("" +4.0, ""+ OperationUnderTest.getRightOperand(operationPart, indexOfOperation));
	}
}
