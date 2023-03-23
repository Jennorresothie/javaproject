package com.shinhan.day04;

public class App {

	public static void main(String[] args) {
		f1();

	}
	
	private static void f1() {
		Calculator cal = new Calculator("red", "super", 100);
		print(cal);
		
	}

	private static void print(Calculator cal) {
		// TODO Auto-generated method stub
		System.out.println();
		
		cal.powerOn();
		cal.powerOff();
	}
	
}
