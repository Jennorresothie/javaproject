package com.shinhan.day09;

public class ThreadB extends Thread {
	
	WorkObject workObject;
	public ThreadB(WorkObject workObject) {
		super("스레드 B");
		this.workObject=workObject;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			workObject.methodB();
		}
	}
	
}
