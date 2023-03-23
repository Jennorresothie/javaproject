package com.shinhan.day09;

import lombok.Getter;
import lombok.Setter;

@Setter

public class SafeThread extends Thread {

	@Override
	public void run() {

		while (true) {
			System.out.println("SafeThread... 실행중");
			if(Thread.interrupted()) break;
		}

		System.out.println("자원 정리");
		System.out.println("SafeThread... 종료");
	}

}
