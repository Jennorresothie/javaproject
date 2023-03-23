package com.shinhan.day04;

// class : object를 만들기위한 틀
// object : class를 이용해서 만들어진 실체, instance라고도 함
public class Calculator {
	// class에 들어가 수 있는것 5가지 
	// field: 특징, 속성, (static, instance)변수
	static String company = "라인";
	String color;
	String model;
	int price;
	
	// 생성자 : 생성시(new) 자동으로 실행되는 메서드, return 금지!, 초기화가 목적!
	// 컴파일시 자동으로 바이트코드 파일에 default 생성자가 생성됨
	// 생성자를 정의하면 default 생성자 자동으로 안생김
	Calculator(String color){
		this(color,"메신저",0); // code 유지보수성을 고려해서 하나의 생성자가 다른 생성자를 호출하여 코드의 반복성을 줄임.
	}
	// 생성자 오버로딩 : 이름은 같지만 매개변수의 개수 타입 순서가 다름
	Calculator(String color, String model){
		this(color,model,0);
	}
	Calculator(String color, String model, int price){
		this.color = color; // this : 현재 객체, 가장까가운 변수만 참조해서 자기 자신만 참조함으로 현재 객체의 맴버 변수를 사용수 있도록 사용
		this.price = price; 
		this.model = model; 
	}
	
	// 일반 메소드: 기능 구현
	void powerOn() {
		System.out.println(color + " " + model + "모델의 계산기 전원 킴");
	}
	void powerOff() {
		System.out.println(color + " " + model + "모델의 계산기 전원 끔");
	}
	int add(int a, int b) {
		return a+b;
	}
	
	// block
	{ // instance block : instance생성시마다 수행
		
	}
	
	static{ // static block : load 될때 1회 시행
		
	}
	
	// inner class : 특정 클래스안에서 사용하기 위한 클래스
	class AA {
		
	}
}
