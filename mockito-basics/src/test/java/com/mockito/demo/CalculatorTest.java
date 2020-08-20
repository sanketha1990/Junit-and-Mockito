package com.mockito.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator cal = null;

	@BeforeEach
	void setUp() throws Exception {
		cal = new Calculator();
	}

	@Test
	void testAddTwo() {
		assertEquals(2, cal.addTwo(1, 1));
	}

	@Test
	void testMultiplyTwo() {
		assertEquals(4, cal.multiplyTwo(2, 2));
	}

	@Test
	void testDivideTwo() {
		assertEquals(4,cal.divideTwo(16, 4));
	}

	@Test
	void testSubstractTwo() {
		assertEquals(2, cal.substractTwo(4, 2));
	}

}
