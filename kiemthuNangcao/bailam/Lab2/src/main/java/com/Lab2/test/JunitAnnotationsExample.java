package com.Lab2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotationsExample {
	private ArrayList<String> list;
	
	@BeforeClass
	public static void m1() {
		System.out.println("Using @BeforeClass annotations, executed before all test case");
	}
	
	@Before
	public void m2() {
		list = new ArrayList<String>();
		System.out.println("Using @Before annotations, executed before each test case");
	}
	
	@AfterClass
	public void m3() {
		System.out.println("Using @AfterClass, executed alter all test cases");
	}
	
	@After
	public void m4() {
		list.clear();
		System.out.println("Using @After, excected after each test cases");
	}
	
	@Test
	public void m5() {
		list.add("test");
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
	}
	
	@Ignore
	public void m6() {
		System.out.println("Using @Ignore, this execution is ignore");
	}
	
	@Test(timeout = 10)
	public void m7() {
		System.out.println("Using @Test(timeout), it can be used to enfore timeout in JUnit 4 test cases");
		
	}
	
	@Test(expected = NoSuchMethodException.class)
	public void m8() {
		System.out.println("Using @Test(expected), it will check for specifield expected during its executin");
		
	}
}
