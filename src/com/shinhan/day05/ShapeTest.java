package com.shinhan.day05;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] s = new Shape[2];
		s[0] = new Rectangle(5,6);
		s[1] = new RectTriangle(6,2);
		
		for (Shape ss : s) {
			System.out.println("area: "+ss.getArea());
			System.out.println("perimeter: "+ss.getPerimeter());
			if (ss instanceof Rectangle r) {
				r.resize(0.5);
				System.out.println("new area: "+r.getArea());
				System.out.println("new perimeter: "+r.getPerimeter());
			}
		}

	}

}
