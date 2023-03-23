package com.shinhan.day05;

public class CarTest {

	public static void main(String[] args) {
		go(new Tire());
		go(new KumhoTire());
		go(new HankukTire());
	}
	static void go(Tire tire) {
		tire.roll(); 
	}

}
