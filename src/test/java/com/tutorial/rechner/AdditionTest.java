package com.tutorial.rechner;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tutorial.rechner.Addition;

public class AdditionTest {


	@Test
	public void addPositiv() {
		Addition additionUnderTest = new Addition(2, 3);
		assertEquals(6, additionUnderTest.add(),0);
	}

	

	@Test
	public void addNegative() {
		Addition additionUnderTest = new Addition(-2, 3);
		assertEquals(1, additionUnderTest.add(),0);
	}
}
