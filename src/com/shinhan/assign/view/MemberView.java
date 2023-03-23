package com.shinhan.assign.view;

import java.util.List;

import com.shinhan.assign.VO.MemberVO;

public class MemberView {
	public static void print(List<MemberVO> memlist) {
		System.out.println("==============회원 정보===============");
		System.out.println();

		for (MemberVO mem : memlist) {
			System.out.println(mem);
		}

		System.out.println();
	}

	public static void print(MemberVO mv) {
		System.out.println("==============회원 정보===============");
		System.out.println();

		if (mv == null)
			print("해당 회원에 대한 정보가 없습니다.");

		else
			System.out.println(mv);

		System.out.println();
	}

	public static void print(String message) {

		System.out.println(" [알림] : " + message);

		System.out.println();
	}
}
