package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User2Thread extends Thread {

	Calculator claculator;
	
	User2Thread(){
		setName("UserThread2!!");
	}
	
	@Override
	public void run() {
		claculator.setMemory(50);
	}
}
