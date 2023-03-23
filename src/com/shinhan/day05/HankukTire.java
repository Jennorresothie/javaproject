package com.shinhan.day05;

public class HankukTire extends Tire{
	
	String info = "한국타이어 최고";
	
	void fun1() {
		System.out.println("한국타이어 전용 메소드");
	}
	
	void roll() { // 재정의
		System.out.println("한국 타이어가 굴러감");
	}
}
