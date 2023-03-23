package com.shinhan.day09;


public class WorkObject { // 공유 영역
	
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"작업 실행A.......");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"작업 실행B.......");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
