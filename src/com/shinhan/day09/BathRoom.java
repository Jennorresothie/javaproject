package com.shinhan.day09;
	
public class BathRoom {
	boolean isFirst = true;
	public void use(String name) {
		synchronized (this) {
			if(isFirst && name.equals("김씨")) {
				try {
					wait(); // notify, notifyAll의 신호가 올때까지 일시정지상태ㄴ
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			isFirst=false;
			System.out.println(name + "입장한다");
			System.out.println(name + "사용한다");
			System.out.println(name + "퇴장한다");
			System.out.println("=======================");
			notifyAll();
			// 신호를 보낸다. wait 상태에 있는 Thread가 실행대기상태로 변한다
		}
	}
	
	
//	// 특정부분 동기화
//	void use(String name) {
//		synchronized (this) {
//			System.out.println(name + "입장한다");
//			System.out.println(name + "사용한다");
//			System.out.println(name + "퇴장한다");
//			System.out.println("=======================");
//		}
//	}
	
	/* 전체 동기화
	synchronized void use(String name) {
		System.out.println(name + "입장한다");
		System.out.println(name + "사용한다");
		System.out.println(name + "퇴장한다");
		System.out.println("=======================");
	}
	
	

	*/
}
