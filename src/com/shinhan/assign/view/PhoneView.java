package com.shinhan.assign.view;

import java.util.List;

import com.shinhan.assign.VO.PhoneVO;

public class PhoneView {
	public static void print(List<PhoneVO> phlist) {
		System.out.println("==============전화번호 정보===============");
		System.out.println();
		
		for(PhoneVO pv : phlist) {
			System.out.println(pv);
		}
		
		System.out.println();
	}
	
	public static void print(PhoneVO pv) {
		System.out.println("==============전화번호 정보===============");
		System.out.println();
		
		if(pv == null)
			print("없는 전화 번호 입니다.");
		else
			System.out.println(pv);
		
		System.out.println();
	}

	public static void print(String message) {
		System.out.println(" [알림] : " + message);

		System.out.println();
		
	}
}
