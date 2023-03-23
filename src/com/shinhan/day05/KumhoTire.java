package com.shinhan.day05;

public class KumhoTire extends Tire {
	
	String info = "금호타이어 최고";
	
	void fun2() {
		System.out.println("금호타이어 전용 메소드");
	}
	
	void roll() { // 재정의
		System.out.println("금호 타이어가 굴러감");
	}
}
