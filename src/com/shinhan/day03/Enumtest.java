package com.shinhan.day03;

public class Enumtest {
	public enum LoginEnum {
		SUCCESS,
		FALSE,
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f2(LoginEnum.SUCCESS);
		f3();
		//f4();
	}

	
	private static void f4() {
		// TODO Auto-generated method stub
		String result = null;
		//if(week == SU)
	}


	private static void f2(LoginEnum login) {
		// TODO Auto-generated method stub
		System.out.println(login == LoginEnum.SUCCESS);
	}

	private static void f3() {
		Week[] weeks = Week.values();
		for (Week week : weeks) {
			System.out.println(week.ordinal()+"=>"+week.name());
		}
		
	}

}
