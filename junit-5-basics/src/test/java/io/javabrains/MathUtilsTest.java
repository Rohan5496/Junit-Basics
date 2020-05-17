package io.javabrains;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;


class MathUtilsTest {
	
	MathUtils mathUtils;
	
	TestInfo testInfo;
	
	TestReporter testReporter;
	
	@BeforeAll
	@Disabled
	static void beforeAllInit() {
		System.out.println("This will run before all the test cases , even before the instance of the test class");
	}
	
	@AfterEach
	@Disabled
	void cleanUp() {
		System.out.println("Cleaning up.....");
	}
	
	@AfterAll
	@Disabled
	static void afterAllCleanUp() {
		System.out.println("Final Clean up.....");
	}
	
	@BeforeEach
	void init(TestInfo testInfo , TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils =  new MathUtils();
		testReporter.publishEntry("Running" + testInfo.getDisplayName());
	}

	@Nested
	@DisplayName("Testing : ADDITION")
	class testAdd{

	@Test
	@DisplayName("Testing : Add Method for Positive")
	void testAddPositive() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "should return correct sum");
	}
	
	@Test
	@DisplayName("Testing : Add Method for Negative")
	void testAddNegative() {
		int expected = -2;
		int actual = mathUtils.add(-1, -1);
		assertEquals(expected, actual, "should return correct sum");
	}
	}
	
	
	@Test
	@DisplayName("multiply method")
	@Disabled
	void testMultiply() {
		assertAll(
				() -> assertEquals(4,mathUtils.multiply(2, 2),()->"should return product of two nos."),
				() -> assertEquals(0,mathUtils.multiply(0, 2),()->"should return product of two nos."),
				() -> assertEquals(-2,mathUtils.multiply(2, -1),()->"should return product of two nos.")
				);
	}

	@RepeatedTest(3)
	@Disabled
	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		System.out.println(totalRepetitions);
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"This method should compute circle area");
	}
	
	@Test
	@Disabled
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "Divide by 0 throws exception");
	}
}
