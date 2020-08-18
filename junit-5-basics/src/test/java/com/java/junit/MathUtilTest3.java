package com.java.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MathUtilTest3 {
	MathUtil mathUtil;

	// We can remove static in this case
	@BeforeAll
	void beforeAllCall() {
		System.out.println("This calls before instantiation");
	}

	@BeforeEach
	void init() {
		System.out.println("Before each method call");
		mathUtil = new MathUtil();
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("After each method call");
	}
	
	@AfterAll
	void afterAllInstantiation() {
		System.out.println("This calls After all instantiation");
	}

	@Test
	void testAddTwo() {
		int expected = 2;
		int actual = mathUtil.addTwo(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	void testAreaOfCircle() {
		double expected = Math.PI * 10 * 10;
		double actual = mathUtil.areaOfCircle(10);
		assertEquals(expected, actual);
	}

	@Test
	void testDivideByNuber1() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divideByNuber(1, 0), "Divide by Zero exception");
	}

}
