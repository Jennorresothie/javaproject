package com.shinhan.day08;

public class Course {
	public static void registerCourse(Applicant<?> app) {
		System.out.println(app.getClass().getSimpleName()+" 가 등록한 과정입니다.");
	}
	
	public static void registerCourse1(Applicant< ? extends Student > app) {
		System.out.println(app.getClass().getSimpleName()+" 가 등록한 과정입니다.");
	}
	
	public static void registerCourse2(Applicant< ? super Worker > app) {
		System.out.println(app.getClass().getSimpleName()+" 가 등록한 과정입니다.");
	}
}
