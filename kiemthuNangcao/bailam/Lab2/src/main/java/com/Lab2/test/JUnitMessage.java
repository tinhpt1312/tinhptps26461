package com.Lab2.test;

public class JUnitMessage {
	private String message;
	
	public JUnitMessage(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println(message);
	}
	
	public String printHiMessage() {
		message = "Hi! " + message; 
		
		System.out.println(message);
		
		return message;
	}

	

}
