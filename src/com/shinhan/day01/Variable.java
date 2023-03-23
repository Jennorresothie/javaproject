package com.shinhan.day01;

// class = variable + method
public class Variable {
	int glo;
	public static void main(String[] args) {
		// 변수 선언
		int a; // 지역 변수 : 초기화 하지 않으면 사용할 수 없음 
		// 변수 사용
		a=10; // 할당
		System.out.println(a);// 읽기
		System.out.println(a+20);
		// 선언+사용
		int a2=30;
		
		/* static은 non-static사용 불가
		System.out.println(glo);// 안되는 이유 : static이 먼저 메모리에 올라가게 되어서 못 불러와서 오류남
		*/
		/** .java->컴파일->.class
		 * 실행 
		 * 1. jvm이 Variable class loader에 의해 load (static이 method 영역에 올라간다)
		 * 2. 검증
		 * 3. main 시작
		 * */
	}

}
