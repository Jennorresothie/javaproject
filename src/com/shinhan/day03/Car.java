package com.shinhan.day03;

public class Car { // 설계도
	// 1. field (속성, 변수) : 특징을 저장할 때 사용
	String model;
	String color;
	int price;
	// 2. 생성자 메서드 (생성시 초기화 목적)
	public Car(){
		System.out.println("생성자");
	}

	// 3. 일반 메서드 (method, 기능, 동작)
	void go() {
		System.out.println("부릉 출발");
	}
	
	// 4. block(instance block, static block)
	{
		System.out.println("2. 인스턴스 블록");
	}
	static {
		System.out.println("1. static 블록");
	}
	
	// 5. inner class

}
