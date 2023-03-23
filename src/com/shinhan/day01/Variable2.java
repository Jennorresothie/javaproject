package com.shinhan.day01;

public class Variable2 {
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		f1(); // 함수 호출
		
		System.out.println("main 종료");
	}

	private static void f1() { // 함수 정의
		int a; 
		System.out.println(a=10);
		System.out.println(a==10);
	}

}
