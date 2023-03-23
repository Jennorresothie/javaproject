package com.shinhan.day06;

public class Cup implements Colorable {
	int size;
	String foregroundColor;
	String backgroundColor;
	
	@Override
	public void setForground(String color) {
		foregroundColor = color;
		System.out.println("Cup의 Forground변경 "+color);
		
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Cup의 Background변경 "+color);
	}

}
