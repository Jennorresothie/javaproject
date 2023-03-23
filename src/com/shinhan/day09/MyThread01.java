package com.shinhan.day09;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyThread01 extends Thread{

	public MyThread01(String string) {
		super(string);
	}

	@Override
	public void run() {
		for(int i=1;i<=26;i++)
			System.out.println(getName()+" i= "+i);
		System.out.println(getName()+"종료============================");
	}
	
}
