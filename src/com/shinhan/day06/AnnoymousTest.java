package com.shinhan.day06;

public class AnnoymousTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		f4();
	}
	
	private static void f4() {
		RemoteControl tv = new RemoteControl() {
			// 내부에서만 사용가능
			// 외부에서는 type이 RemoteControl이므로 RemoteControl에서 정의된 값외에는 사용할 수 없다.
			int a=10;
			public void method() {
				System.out.println("구현class에서 메소드 추가");
			}
			
			public void turnOn() {
				System.out.println("전원을 킨다");
			}

			public void turnOff() {
				System.out.println("전원을 끈다");
			}
			
		};
		tv.turnOff();
		tv.turnOn();
		
	}

	private static void f1() {
		//1. 일반적인 방법
		Book book = new Book();
		book.title = "이것이 자바다";
		book.setForground("white");
		book.setBackground("blue");
		
		Cup cup = new Cup();
		cup.size=10;
		cup.setBackground("black");
		cup.setForground("navy");
	}
	
	// 인터페이스를 따르는 구현 class들을 많이 만들어야하는 비효율발생
	// 이름이 없는 클래스 만들어 임시로 사용하고 싶을때 사용
	// 익명 객체
	private static void f2() {
		Colorable a = new Colorable() {

			public void setForground(String color) {
				System.out.println("익명..setForground "+color);
				
			}

			public void setBackground(String color) {
				System.out.println("익명..setBackground "+color);
				
			}
			
		};
		
		a.setBackground("red");
		a.setForground("orange");
	}
	
	private static void f3() {
		(new Colorable() {

			public void setForground(String color) {
				System.out.println("익명..setForground "+color);
				
			}

			public void setBackground(String color) {
				System.out.println("익명..setBackground "+color);
				
			}
			
		}).setBackground("green");
		
	}

}
