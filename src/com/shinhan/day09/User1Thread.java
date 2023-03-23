package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User1Thread extends Thread {

	Calculator claculator;
	
	User1Thread(){
		
		setName("UserThread1!!");
	}
	
	
	
	@Override
	public void run() {
		claculator.setMemory(50);
	}
}
