package com.shinhan.day02;

import java.util.Scanner;

public class 문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total=0;
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			String num = sc.nextLine();
			if(num.equals("1")){
				Scanner in = new Scanner(System.in);
				System.out.print("예금액>");
				String money = in.nextLine();
				total+=Integer.parseInt(money);
			}
			else if(num.equals("2")){
				Scanner in = new Scanner(System.in);
				System.out.print("출금액>");
				String money = in.nextLine();
				total-=Integer.parseInt(money);
			}
			else if(num.equals("3")){
				Scanner in = new Scanner(System.in);
				System.out.println("잔고>"+total);
				
			}
			else if(num.equals("4"))
				break;
			System.out.println();	
				
		}
		System.out.println("\n프로그램 종료");	
			
	}


}
