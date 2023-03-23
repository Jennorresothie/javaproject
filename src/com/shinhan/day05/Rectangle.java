package com.shinhan.day05;

public class Rectangle extends Shape implements Resizable {
	private double width, height; 

	Rectangle(double width, double height) {
		super(4);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		return width*height;
	}

	@Override
	double getPerimeter() {
		return (width+height)*2.0;
	}

	@Override
	public void resize(double s) {
		this.width *=s;
		this.height *=s;
	}
	
}
