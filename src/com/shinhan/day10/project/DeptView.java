package com.shinhan.day10.project;

import java.util.*;

public class DeptView {

	public static void print(String message) {
		System.out.println();
	}
	
	public static void print(DeptVO dept) {
		System.out.println("dept 정보 "+dept);
	}
	
	public static void print(List<DeptVO> dl) {
		System.out.println("=========dept list==========");
		for(DeptVO dept:dl) {
			System.out.println(dept);
		}
	}
}
