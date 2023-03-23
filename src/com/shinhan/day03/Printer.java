package com.shinhan.day03;

public class Printer {
	public static Printer singleTone = new Printer();
	
	public static Printer getInstance() {
		return singleTone;
	}
	
}
