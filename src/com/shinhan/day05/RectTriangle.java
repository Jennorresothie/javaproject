package com.shinhan.day05;

public class RectTriangle extends Shape {
	private double width, height; 

	RectTriangle(double width, double height) {
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		return width*height/2.0;
	}

	@Override
	double getPerimeter() {
		double c = Math.sqrt(Math.pow(height,2)+Math.pow(width, 2));
		return width+height+c;
	}
	
}
