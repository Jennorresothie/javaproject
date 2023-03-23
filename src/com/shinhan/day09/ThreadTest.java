package com.shinhan.day09;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		f5();
	}

	private static void f5() {
		SafeThread s = new SafeThread();
		s.start();
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			// TODO: handle exception
		}
		s.interrupt();
		//s.stop 사용하지 않는 것이 좋다
		
	}

	private static void f4() {
		//Thread에서 다른 스레드에게 신호보내기
		WorkObject obj = new WorkObject();
		ThreadA t = new ThreadA(obj);
		ThreadB t2 = new ThreadB(obj);
		t.start(); t2.start();
		
	}

	private static void f3() {
		ShareArea share = new ShareArea(
				new Account("123456", "이몽룡", 2000),
				new Account("456789", "성춘향", 1000)
				);
		TransferThread t = new TransferThread(share);
		PrintThread t2 = new PrintThread(share);
		t.start(); t2.start();
	}

	// 동기화
	private static void f2() {
		// 익명 스레드 만들기
		User1Thread t = new User1Thread();
		User2Thread t2 = new User2Thread();
		// 공유 영역
		Calculator cal = new Calculator();
		
		t.setClaculator(cal);
		t2.setClaculator(cal);
		
		t.start();
		t2.start();
		
	}

	private static void f1() {
		BathRoom bathRoom = new BathRoom();
		BathThread t = new BathThread(bathRoom, "김씨");
		BathThread t2 = new BathThread(bathRoom, "이씨");
		BathThread t3 = new BathThread(bathRoom, "박씨");
		BathThread t4 = new BathThread(bathRoom, "나씨");
		t.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	private static void f() throws InterruptedException {
		WorkThread t = new WorkThread("스레드 A");
		WorkThread t2 = new WorkThread("스레드 B");
		t.start();
		t2.start();
		
		// 5초간 일시정지
		Thread.sleep(5000);
		// t의 work false
		t.work=false;
		// 10초 후 
		Thread.sleep(10000);
		// t의 work true
		t.work=true;
	}
	

}
