package com.Lab2.test;

public class MathUtils {
	public static int divide(int input1, int input2) {
		if(input2 == 0) {
			throw new ArithmeticException("divide by zero");
		}
		return input1/input2;
	}
}
