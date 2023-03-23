package com.shinhan.day03;

public class ComputerTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Computer com1 = new Computer();
		Computer com2 = new Computer("LG 그램");
		Computer com3 = new Computer("WINDOW", 100);
		Computer com4 = new Computer("samsung", "mac", 200);
		display(com1);
		display(com2);
		display(com3);
		display(com4);
		
	}

	private static void display(Computer com) {
		System.out.println();
		com.computerInfoprint();
		System.out.println(Computer.count);
	}

}
