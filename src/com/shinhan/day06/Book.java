package com.shinhan.day06;

public class Book implements Colorable{
	String foregroundColor;
	String backgroundColor, title;

	@Override
	public void setForground(String color) {
		foregroundColor = color;
		System.out.println("Book의 Forground변경 "+color);
		
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Book의 Background변경 "+color);
	}

}
