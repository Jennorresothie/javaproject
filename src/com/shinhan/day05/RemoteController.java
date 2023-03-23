package com.shinhan.day05;

public interface RemoteController {
	void powerOn();
	void powerOff();
	default void display() {
		System.out.println("기능 추가");
	}
	static void display2() {
		System.out.println("모든구현 class에서 수정 불가능");
	}
}
