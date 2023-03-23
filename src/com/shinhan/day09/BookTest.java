package com.shinhan.day09;

public class BookTest {

	public static void main(String[] args) {
		Book<String> b1 = new Book<>("이거시 자바다",35000,"한빛 미디어",new String[] {"신용권", "임경균"});
		Book<String> b5 = new Book<>("이거시 자바다",35000,"한빛 미디어",new String[] {"신용권", "임경균"});
		Book<Integer> b2 = new Book<>(20000,30000,"가즈아",new String[] {"신용권"});
		Book<Integer> b3 = new Book<>(999,27000,"퍼스트존",new String[] {"신용권"});
		Book<String> b4 = Book.makeBook("자바 웹 구현", 25000);
		
		int  result = b1.compareTo(b4);
		System.out.println(result);
		System.out.println(b1.equals(b5));
		System.out.println(Book.getCount());
		
	}

}
