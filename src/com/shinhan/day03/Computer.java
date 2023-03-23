package com.shinhan.day03;

public class Computer {
	private String model;
	private String os;
	private int price; //가격은 아무나 변경 못하게 은닉화
	static int count;
	// 생성자
	public Computer(){
		this("AA", "Linux", 700000);
		System.out.println("default 생성자로 생성");
	}
	
	// 생성자 overloading
	public Computer(String model){
		this(model, "Linux", 700000);
		System.out.println("생성자 오버로딩 1로 생성");
		 // 현재 객체의 model에 값을 넣기위해 this 사용
	}
	
	// 생성자 overloading 매개변수의 타입 순서 개수를 다르게 하기 위해 price 추가
	public Computer(String os, int price){ 
		this("AA",os,price);
		System.out.println("생성자 오버로딩 2로 생성");
		
	}
	public Computer(String model, String os, int price){ 
		System.out.println("생성자 오버로딩 3로 생성");
		this.model = model;
		this.os = os;
		this.price = price;
		count++;
	}
	
	// 일반 메서드
	public void computerInfoprint() {
		System.out.println("model:" + model);
		System.out.println("os: "+ os);
		System.out.println("price: "+ price);
	}
	public String getModel() {
		return model;
	}
	public String getOs() {
		return os;
	}
	public int getPrice() {
		return price;
	}
	
}
