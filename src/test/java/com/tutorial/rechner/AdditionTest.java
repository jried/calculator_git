package com.tutorial.rechner;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tutorial.rechner.Addition;

public class AdditionTest {


	@Test
	public void addPositiv() {
		Addition additionUnderTest = new Addition(2, 3);
		assertEquals(5, additionUnderTest.add(),0);
	}

	@Test
	public void addPositiv2() {
		Addition additionUnderTest = new Addition(5, 3);
		assertEquals(7, additionUnderTest.add(),0);
	}
	

	@Test
	public void addNegative() {
		Addition additionUnderTest = new Addition(-2, 3);
		assertEquals(1, additionUnderTest.add(),0);
	}
}
