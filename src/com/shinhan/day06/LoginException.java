package com.shinhan.day06;

public class LoginException extends Exception {
	
	public LoginException(String errMessage) {	
		super(errMessage);		
	}
	
	public void printMessage() {
		System.out.println("로그인: "+getMessage());
	}
}
