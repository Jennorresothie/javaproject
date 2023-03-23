package com.shinhan.day05;

public class InterfaceTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		On(new Television());
		On(new Audio());
	}

	private static void On(RemoteController remote) {
		// 자동 형변환 됨 + over ride => 다형성
		// 사용법은 같고 결과는 다양하다
		System.out.println("------------------------------------------");
		remote.powerOn();
		remote.powerOff();
		remote.display();
		RemoteController.display2();
	}

}
