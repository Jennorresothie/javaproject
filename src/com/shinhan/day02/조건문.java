package com.shinhan.day02;

import java.util.Scanner;

public class 조건문 {

	public static void main(String[] args) {
		함수3();

	}

	private static void 함수3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("월>>");
		int month = sc.nextInt();
		String message = "";
		
		switch (month) {
		case 1:
		case 2:
		case 12:
			message="겨울";
			break;
		case 3:
		case 4:
		case 5:
			message="봄";
			break;
		case 6:
		case 7:
		case 8:
			message="여름";
			break;
		case 9:
		case 10:
		case 11:
			message="가을";
			break;
		default:
			message="잘못된 입력입니다";
			break;
		}
		System.out.println(month+"은 "+message+"입니다");
		
	}

	private static void 함수2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수>>");
		int score = sc.nextInt();
		String grade = "";
		
		switch (score/10) {
		case 10:
		case 9:
			grade="A";
			break;
		case 8:
			grade="B";
			break;
		case 7:
			grade="C";
			break;
		case 6:
			grade="D";
			break;
		default:
			grade="F";
			break;
		}
		System.out.println("결과는 "+score+"==>"+grade);
	}

	private static void 함수() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수>>");
		int score = sc.nextInt();
		String grade = "";
		if(score>=90) {
			grade="A";
		}
		else if(score>=80) {
			grade="B";
		}
		else if(score>=70) grade="C";
		else if(score>=60) grade="D";
		else grade="F";
		System.out.println("결과는 "+score+"==>"+grade);
	}

}
