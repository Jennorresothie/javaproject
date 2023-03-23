package com.shinhan.day06;

public class ExceptionTest {

	public static void main(String[] args) throws LoginException  {
		
		// 영문자가 아니라서 예외 발생 시킴
		String pass = "123456"; 
		char ch = pass.charAt(0);
		if(ch<'A' || ch>'Z')
			throw new LoginException("대문자가 아니다. 대문자로 시작해야한다.");
	}

}
