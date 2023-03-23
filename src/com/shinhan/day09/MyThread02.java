package com.shinhan.day09;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyThread02 extends Thread{

	public MyThread02(String string) {
		super(string);
	}

	@Override
	public void run() {
		for(char i='A';i<='Z';i++)
			System.out.println(getName()+" i= "+i);
		System.out.println(getName()+"종료============================");
	}
	
}
