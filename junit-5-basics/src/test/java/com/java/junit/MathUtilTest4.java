package com.java.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class MathUtilTest4 {
	MathUtil mathUtil;
	TestInfo testInfo;
	TestReporter testReporter;

	// We can remove static in this case
	@BeforeEach
	@Tag("Math")
	@RepeatedTest(3)
	void init(TestInfo testInfo, TestReporter testReporter) {
		
		//System.out.println("Get current repetition info "+repInfo.getCurrentRepetition()+" Total repetitions "+repInfo.getTotalRepetitions());
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println("Before each method call");
		mathUtil = new MathUtil();
	}

	@Test
	@Tag("PROD")
	@DisplayName("AssertAll : Multiplication of two number")
	void assertAllProd() {
		testReporter.publishEntry("Running =" + testInfo.getDisplayName() + " with Tags " + testInfo.getTags());
		assertAll(() -> assertEquals(mathUtil.multiplication(2, 1), 2),
				() -> assertEquals(mathUtil.multiplication(3, 3), 9),
				() -> assertEquals(mathUtil.multiplication(3, 0), 0),
				() -> assertEquals(mathUtil.multiplication(2, -1), -2)

		);
	}

	@Nested
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
	@DisplayName("Test add two number")
	void testAddTwoNumber() {
		int expected = 4;
		int actual = mathUtil.addTwo(2, 2);
		assertEquals(expected, actual, "Expected number = " + expected + " Actual number " + actual);
	}

}
