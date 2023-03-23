package com.shinhan.day09;

public class MyThread03 extends Object implements Runnable{
	
	public MyThread03( ) {
		
	}
	
	public MyThread03(String name) {
		Thread.currentThread().setName(name);
	}

	@Override
	public void run() {
		for(char i='a';i<='z';i++)
			System.out.println(Thread.currentThread().getName()+" i= "+i);
		System.out.println(Thread.currentThread().getName()+"종료============================");
	}
	
}
