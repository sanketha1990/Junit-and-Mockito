package com.java.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class MathUtilTest5 {
	MathUtil mathUtil;

	// We can remove static in this case
	@BeforeEach
	@Tag("Math")
	void init() {
		System.out.println("Before each method call");
		mathUtil = new MathUtil();
	}

	@Test
	@DisplayName("Test Add two number")
	@EnabledOnJre(JRE.JAVA_11)
	@Tag("Math")
	void testAddTwo() {
		int expected = 2;
		int actual = mathUtil.addTwo(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test Area of Circle")
	@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testAreaOfCircle() {
		double expected = Math.PI * 10 * 10;
		double actual = mathUtil.areaOfCircle(10);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test Divide By Number")
	@Disabled
	@Tag("Math")
	void testDivideByNuber1() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divideByNuber(1, 0), "Divide by Zero exception");
	}

	@Test
	@DisplayName("Test assume method")
	@Tag("Math")
	void assumeMethod() {
		boolean isServerUp = true;
		assumeTrue(isServerUp);
		System.out.println("This executes if the server is up");
	}

	@Test
	@Tag("Math")
	@DisplayName("AssertAll : Multiplication of two number")
	void assertAllProd() {
		assertAll(() -> assertEquals(mathUtil.multiplication(2, 1), 2),
				() -> assertEquals(mathUtil.multiplication(3, 3), 9),
				() -> assertEquals(mathUtil.multiplication(3, 0), 0),
				() -> assertEquals(mathUtil.multiplication(2, -1), -2)

		);
	}

	@Nested
	@Tag("Math")
	@DisplayName("TestCase: Divide By Number")
	class TestCase {
		@Test
		@DisplayName("Test Divide By Number")
		void testDivideByNuber1() {
			assertThrows(ArithmeticException.class, () -> mathUtil.divideByNuber(1, 0),
					"Divide by Zero exception with ArithmeticException");
		}

		@Test
		@DisplayName("Test Divide By Number")
		void testDivideByNuber2() {
			assertThrows(Exception.class, () -> mathUtil.divideByNuber(1, 0),
					"Divide by Zero exception with Exception class");
		}
	}
	
	@Test
	@Tag("Two")
	@DisplayName("Test add two number")
	void testAddTwoNumber() {
		int expected=4;
		int actual=mathUtil.addTwo(2, 2);
		assertEquals(expected, actual,"Expected number = "+expected+" Actual number "+actual);
	}

}
