package com.shinhan.day03;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

	private static void f1() {
		// 자동차 객체를 만든다
		//1. 객체참조변수선언 : 변수로 예를 들자면 ex)int a; //a변수에 int타입의 값을 담을 수 있다.
		Car car1; // car1 변수에 Car타입 객체를 담을 수 있다.
		Car car2;
		
		//2. 객체 생성 : heap에 객체가 생성되고 주소는 변수에 담는다. 
		car1 = new Car(); // 객체가 생성되면 변수들은 자동 초기화 된다.
		car2 = new Car();
		//3. 객체 사용
		System.out.println(car1.model + " " + car1.color + " " + car1.price);
		car1.go();
	}

}
