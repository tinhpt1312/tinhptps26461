package com.Lab2.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ToanHocTest {
	private ToanHoc fixture;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Setup");
		fixture=new ToanHoc();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown");
		fixture=null;
	}
	
	@Test
	public void testTru() {
		System.out.println("Test Tru Method");
		int result=fixture.minus(7, 4);
		int expected=3;
		assertEquals(expected,result);
	}
	@Test
	public void testCong() {
		System.out.println("Test Cong Method");
		int result=fixture.plus(7, 5);
		int expected=12;
		assertEquals(expected,result);
	}
	

}
