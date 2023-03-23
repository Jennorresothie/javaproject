package com.shinhan.day03;

public class Member {
	private String name, id, password;
	private int age;
	
	Member(String name, String id){
		this.name = name;
		this.id = id;
	}
	
	public boolean login(String id, String password) {
		if (id.equals("hong")&&password.equals("12345"))
			return true;
		return false;
	}
	
	public void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다");
	}
}
