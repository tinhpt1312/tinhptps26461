package com.Lab2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MathUtilsTest {
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(expected = ArithmeticException.class)
	public void testMathUtils1() {
		MathUtils.divide(100, 0);
	}
	
	@Test
	public void testMathUtils2() {
		try {
			MathUtils.divide(100, 0);
			fail("Should throw ArithmeticException: divide by zero");
		} catch (Exception e) {
			// TODO: handle exception
			MatcherAssert.assertThat(e, new IsInstanceOf(ArithmeticException.class));
			assertEquals(e.getMessage(), "divide by zero");
		}
	}
	
	@Test
	public void testTrycatch() {
		try {
			MathUtils.divide(1, 1);
		} catch (Exception e) {
			// TODO: handle exception
			fail("Throw exception");
		}
	}
	
	@Test
	public void testExceptionMessage() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("divide by zero");
		MathUtils.divide(100, 0);
	}
}
