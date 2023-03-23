package com.shinhan.day07;

public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		String obj = new String();
		String obj2 = new String();
		
		System.out.println(System.identityHashCode(obj));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj==obj2); // 기본형는 값을 비교, 객체는 주소 비교
		System.out.println(obj.equals(obj2)); // 내용 비교로 재정의
	}

}
