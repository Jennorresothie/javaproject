package com.shinhan.day10;

//1. 스레드 상속
class MyThreadA extends Thread{
	MyThreadA(String name){
		super(name);
	}
	public void run() { // thread.start()하면 run()호출된다.
		for(int i=1;i<11;i++) {
			System.out.println(getName()+ " : " +i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}

//2. interface 구현
class MyThreadB implements Runnable {
	
	public void run() {
		for(int i=1;i<11;i++) {
			System.out.println(Thread.currentThread().getName()+ " : " +i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}

public class Review {
	public static void main(String[] args) {
		Thread t = new MyThreadA("스레드 A");
		Thread t2 = new Thread(new MyThreadB());
		t2.setName("스레드 B");
		Thread t3 = new Thread() {
			public void run() { // thread.start()하면 run()호출된다.
				setName("스레드 C");
				for(int i=1;i<11;i++) {
					System.out.println(getName()+ " : " +i);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t4 = new Thread(new Runnable() {
			
			public void run() {
				for(int i=1;i<11;i++) {
					System.out.println(Thread.currentThread().getName()+ " : " +i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}
		});
		t.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
