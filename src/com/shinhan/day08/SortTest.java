package com.shinhan.day08;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	
	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		Car[] arr = {new Car("Spring", 100), new Car("java", 50), new Car("jsp", 50), new Car("servlet", 40), new Car("html", 10), new Car("CSS", 30), new Car("React",400)};
		System.out.println("Before: "+Arrays.toString(arr));
		
		Arrays.sort(arr); // 오름차순
		System.out.println("After: "+Arrays.toString(arr));
		
		Arrays.sort(arr, new Comparator<Car>() { // 클래스 내림차순을 익명 클래스로 구현

			public int compare(Car o1, Car o2) {
				
				int result = o2.price - o1.price; // 내림차순
				if (result==0) return o1.name.compareTo(o2.name); // 가격이 같은 것은 오름차순
				return result; 
			}
		});
		System.out.println("After: "+Arrays.toString(arr));
		
		
	}
	
	private static void f2() {
		String[] arr = new String[] {"Spring", "java", "jsp", "servlet", "html", "CSS", "React"};
		System.out.println("Before: "+Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println("After: "+Arrays.toString(arr));
		
		Arrays.sort(arr, new Comparator<String>() { // 내림차순을 익명 클래스로 구현
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
				}
		});
		System.out.println("After: "+Arrays.toString(arr));
	}
	
	private static void f1() { 
		Integer[] arr = new Integer[] {100,30,80,20,99}; 
		System.out.println("Before: "+Arrays.toString(arr));
		
		Arrays.sort(arr); // 오름차순
		System.out.println("After: "+Arrays.toString(arr));
		
		Arrays.sort(arr, new DecendingInteger()); // 내림차순을 따로 클래스로 만들어서 구현
		System.out.println("After: "+Arrays.toString(arr));
		
	}
}
