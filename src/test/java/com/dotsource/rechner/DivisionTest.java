package com.dotsource.rechner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class DivisionTest {

	@Test
	public void testPositiveCase() {
		Division divisionUnderTest = new Division(10, 2);
		assertEquals(5, divisionUnderTest.divide(),0);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testDivideByZero() {
		Division divisionUnderTest = new Division(10, 0);
		divisionUnderTest.divide();
	}

}
