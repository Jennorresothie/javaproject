package com.shinhan.day04;

// Servlet : JAVA(main) + HTML(쓸 수 있지만 권장 안함) 서버에서 수행되는 자바프로그램
// jsp : HTML(main) + JAVA(쓸 수 있지만 권장 안함), jsp->Servlet으로 변경됨
// Servlet은 싱글톤으로 동작, 생성을 1회만!!
public class Myservlet {
	
	private static Myservlet servlet; //참조변수 선언, [modifier] 타입 변수;
	
	private Myservlet() {// 생성자
		
	}
	
	public static Myservlet getInstance() { // [modifier] 반환타입 메소드() { 실행문 }
		// 만약 생성된적 없을때만 생성해
		if (servlet==null)
			servlet = new Myservlet();
		return servlet; 
	}
}
