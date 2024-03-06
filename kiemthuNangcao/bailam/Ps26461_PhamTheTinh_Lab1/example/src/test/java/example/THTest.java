package example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class THTest {
	private ToanHoc fixture;
	
	public THTest() {
		fixture = new ToanHoc();
	}
	
	@Test
	public void testPlus() {
		int result = fixture.plus(3, 5);
		int expected = 8;
		assertEquals(expected, result);
	}
	
	@Test
	public void testMinus() {
		int result = fixture.minus(10, 4);
		int expected = 10;
		assertEquals(expected, result);
	}
}
