package com.shinhan.day11;

public class Person {

	public void action(Workable workable) {
		
		workable.work("홍길동", "프로그램");
	}
	
	public void action(Speakable speakable) {
		speakable.speak("안녕하세요");
	}
	
	public void action2(Speakable speakable) {
		String str =speakable.speak2("안녕하세요");
		System.out.println(str);
	}
}
