package com.java.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
	void testAddTwo() {
		MathUtil mathUtil = new MathUtil();
		int expected = 2;
		int actual = mathUtil.addTwo(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	void testAreaOfCircle() {
		MathUtil mathUtil = new MathUtil();
		double expected = Math.PI * 10 * 10;
		double actual = mathUtil.areaOfCircle(10);
		assertEquals(expected, actual);
	}

	@Test
	void testDivideByNuber1() {
		MathUtil mathUtil=new MathUtil();
		assertThrows(ArithmeticException.class,()->mathUtil.divideByNuber(1, 0),"Divide by Zero exception");
	}
	
	/*
	 * @Test void testDivideByNuber2() { MathUtil mathUtil=new MathUtil();
	 * assertThrows(NullPointerException.class,()->mathUtil.divideByNuber(1,
	 * 0),"Divide by Zero exception"); }
	 */

}
