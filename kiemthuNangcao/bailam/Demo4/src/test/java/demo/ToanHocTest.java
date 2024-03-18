package demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToanHocTest {
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Before Test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("After Test");
	  }


	  @Test
	  public void CongTest() {
//	    throw new RuntimeException("Test not implemented");
		  ToanHoc fixture=new ToanHoc();
		  int result=fixture.Cong(7, 8);
		  int expected=15;
		  assertEquals(expected, result);
	  }

	  @Test
	  public void TruTest() {
//	    throw new RuntimeException("Test not implemented");
		  ToanHoc fixture=new ToanHoc();
		  int result=fixture.Tru(17, 8);
		  int expected=9;
		  assertEquals(expected, result);
	  }
	}
