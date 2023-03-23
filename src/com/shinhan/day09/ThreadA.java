package com.shinhan.day09;

public class ThreadA extends Thread {
	
	WorkObject workObject;
	public ThreadA(WorkObject workObject) {
		super("스레드 A");
		this.workObject=workObject;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			workObject.methodA();
		}
	}
	
}
