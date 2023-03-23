package com.shinhan.day08;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test2();
		test1();
	}
	
	

	private static void test() {
		// TODO Auto-generated method stub
		Course.registerCourse(new Applicant <Person>(new Person()));
		Course.registerCourse(new Applicant <Student>(new Student()));
		Course.registerCourse(new Applicant <Worker>(new Worker()));
		Course.registerCourse(new Applicant <HighStudent>(new HighStudent()));
		Course.registerCourse(new Applicant <MiddleStudent>(new MiddleStudent()));
	}
	private static void test1() {
		// TODO Auto-generated method stub
		//Course.registerCourse1(new Applicant <Person>(new Person()));
		Course.registerCourse1(new Applicant <Student>(new Student()));
		//Course.registerCourse1(new Applicant <Worker>(new Worker()));
		Course.registerCourse1(new Applicant <HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant <MiddleStudent>(new MiddleStudent()));
	}
	private static void test2() {
		// TODO Auto-generated method stub
		Course.registerCourse2(new Applicant <Person>(new Person()));
		//Course.registerCourse2(new Applicant <Student>(new Student()));
		Course.registerCourse2(new Applicant <Worker>(new Worker()));
		//Course.registerCourse2(new Applicant <HighStudent>(new HighStudent()));
		//Course.registerCourse2(new Applicant <MiddleStudent>(new MiddleStudent()));
	}



	private static void method1() {
		// TODO Auto-generated method stub
		int a=10,b=20;
		boolean result = compare(a,b);
		System.out.println(result);
		
	}
	
	private static <T> boolean compare(T a, T b) {
		return a.equals(b);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box b = new Box("바나나", 100);
		Box b1 = new Box(500, 100);
		
	}
	
	private static void f5() {
		Product<String, Integer> p1 = new Product<>("책",1000);
		System.out.println(p1);
		
	}
//	private static <T,A,B> int f6(T Kind) {
//		Product<String> p1 = new Product<>("책",1000);
//		Product<Integer> p2 = new Product<>("책",1000);
//		System.out.println(p1);
//		
//	}

}
