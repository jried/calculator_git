package com.tutorial.rechner;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tutorial.rechner.Operation;

public class LeftOperandTest {
	Operation OperationUnderTest = new Operation("");
	
/**
 * Start of testing leftOperand method of Operation class
 */
	
	@Test
	public void leftOperandTest() {
		String operationPart = "5.0 + 18.0";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +5.0, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
	
	@Test
	public void leftOperandNegativTest() {
		String operationPart = "-5.0 + 18.0";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +-5.0, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
	
	@Test
	public void leftOperandNegativWithSpaceTest() {
		String operationPart = " -5.0 + 18.0";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +-5.0, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
	
	@Test
	public void leftOperandNegativWithSpaceAndAnotherOperatorTest() {
		String operationPart = "- -5.0 + 18.0";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +-5.0, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
	
	@Test
	public void leftOperandIntTest() {
		String operationPart = "5 + 18";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +5, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
	
	@Test
	public void leftOperandIntTestWithAdditionalOperation() {
		String operationPart = "- -5 + 18";
		int indexOfOperation = operationPart.indexOf("+");
		String operand = " + ";
		assertEquals("" +-5, ""+ OperationUnderTest.getLeftOperand(operationPart, indexOfOperation, operand));
	}
}
