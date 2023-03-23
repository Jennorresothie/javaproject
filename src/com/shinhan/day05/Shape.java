package com.shinhan.day05;

public abstract class Shape {
	int numSides;
	
	Shape(int numSides){
		this.numSides = numSides;
	}
	
	int getNumSides() {
		return numSides;
	}
	
	abstract double getArea();
	abstract double getPerimeter();
	
	
}
