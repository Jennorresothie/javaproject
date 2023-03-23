package com.shinhan.day03;

public class Person {
	private int age;
	private String name;
	static int numberOfPersons;
	
	public Person(){ this(12, "Anonymous"); } 
	public Person(int age, String name){
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}
	
	public void selfIntroduce() {
		System.out.printf("내 이름은 %s이며, 나이는 %d살 입니다\n",name,age);
	}
	
	public int getPopulation() { // 왜 static을 붙이는가?
		return numberOfPersons;
	}
	
	public static void main(String[] args) {
		Person[] p1 = new Person[100];
		
		System.out.println(Person.numberOfPersons);
		
	}
	
}
