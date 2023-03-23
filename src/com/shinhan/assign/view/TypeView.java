package com.shinhan.assign.view;

import java.util.List;

import com.shinhan.assign.VO.TypeVO;

public class TypeView {
	public static void print(List<TypeVO> tvlist) {
		System.out.println("==============유형 정보===============");
		System.out.println();

		for (TypeVO tv : tvlist) {
			System.out.println(tv);
		}

		System.out.println();
	}

	public static void print(TypeVO tv) {
		System.out.println("==============유형 정보===============");
		System.out.println();

		if (tv == null)
			print("해당 직원에 대한 정보가 없습니다.");

		else
			System.out.println(tv);

		System.out.println();
	}

	public static void print(String message) {

		System.out.println(" [알림] : " + message);

		System.out.println();
	}
}
