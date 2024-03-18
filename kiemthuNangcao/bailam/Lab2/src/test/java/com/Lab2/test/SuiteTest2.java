package com.Lab2.test;

import org.junit.Test;

import org.junit.Assert;

public class SuiteTest2 {

	@Test
	public void createAndSetName() {
		String expected = "Y";
		String actual = "Y";
		
		Assert.assertEquals(expected, actual);
		
		System.out.println("Suite Test 1 is successful" + actual);
	}
}
