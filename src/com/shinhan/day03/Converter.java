package com.shinhan.day03;

public class Converter {

	public static void main(String[] args) {
		System.out.println("문자열에 특정문자 변경하는 테스트");
		System.out.println("-------------Sample 1--------------");
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		System.out.println("-------------Sample 2--------------");
		String str2=myReplace("hello world",' ','-');
		System.out.println(str2);
		System.out.println("-------------Sample 3--------------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);

	}

	private static String myReplace(String string, char c, char d) {
		// TODO Auto-generated method stub
		int size=string.length();
		String temp="";
		for(int i=0;i<size;i++) {
			if(string.charAt(i)==c)
				temp+=d;
			else
				temp+=string.charAt(i);
		}
		return temp;
	}

}
