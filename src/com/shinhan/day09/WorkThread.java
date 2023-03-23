package com.shinhan.day09;

public class WorkThread extends Thread {
	public boolean work=true;
	
	public WorkThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName()+"..작업중");
			}
			else {
				Thread.yield(); // 나의 스레드가 잠시 멈춤..다른 스레드에게 양보
			}
		}
	}

}
