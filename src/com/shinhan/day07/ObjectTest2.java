package com.shinhan.day07;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class ObjectTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String fruit = new String();
		StringTokenizer st = new StringTokenizer(fruit, ",/ ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	private static void f3() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s1 = "자바";
		String s2 = new String("자바");
		byte[] arr = new byte[] {44,032,67,97,98,99};
		char[] ch = new char[] {'A','B','C','a','b','c'};
		String s3 = new String(arr);
		String s4 = new String(ch);
		System.out.println(s1+s2+s3+s4);
		String s5 = new String(arr, "utf-8"); //문자가 아니여도 하나당 3byte씩만들어라
		System.out.println(s5);
		System.out.println((long)'가');
		
	}
	private static void f2() {
		// TODO Auto-generated method stub
		Computer c = new Computer();
		Computer c2 = new Computer("a","LG",100);
//		System.out.println(c2.getMaker());
//		System.out.println(c2.getModel());
//		System.out.println(c2.getPrice());
		
		Properties ps =  System.getProperties();
		Set<Object> key = ps.keySet();
		for(Object k : key) {
			System.out.println(k);
			System.out.println(System.getProperty((String)k));
			System.out.println();
		}
			
	}
	private static void f1() {
		// TODO Auto-generated method stub
		ProductVO obj = new ProductVO("컴퓨터", 100, "삼성");
		ProductVO obj2 = new ProductVO("컴퓨터", 100, "삼성");
		
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(obj==obj2); // 주소비교, 자바는 연산자 재정의불가
		System.out.println(obj.equals(obj2)); // 재정의 안하면 주소비교
		
		Set<ProductVO> data = new HashSet<>();
		data.add(obj);
		data.add(obj2);
		for(ProductVO p:data) {
			System.out.println(p);
		}
		
	}

}
