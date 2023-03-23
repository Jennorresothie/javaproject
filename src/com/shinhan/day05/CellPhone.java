package com.shinhan.day05;

import java.util.Objects;

public class CellPhone {
	String model; // 핸드폰 모델 번호
	double battery; // 남은 배터리 양
	
	CellPhone(String model){ // 모델 번호를 인자로 받는 생성자
		this.model = model;
	}
	
	void  call(int time) {
		// 통화 시간(분)이 0 보다 작은 경우에는
		if (time<0) throw new IllegalArgumentException("통화시간입력오류");
		
		// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을 감소시킨다.
		System.out.println("통화시간 : "+time+"분");
		
		// 감소되는 배터리 양 = 통화시간(분) * 0.5
		battery = time*0.5;
		
		// 배터리 양은 0보다 작아지지 않는다.
		if(battery<0) battery=0;
	}
	
	void  charge(int time) {
		// 충전 시간(분)이 0보다 작은 경우에는
		if (time<0) throw new IllegalArgumentException("충전시간입력오류");
		
		// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리양을 증가시킨다.
		System.out.println("충전시간 : "+time+"분");
		
		// 충전되는 배터리 양 = 충전시간(분) * 3
		battery = time*3;
		
		// 배터리 양은 100까지만 증가한다.
		if(battery>100) battery=100;
		
	}
	
	void  printBattery() {
		// 남은 배터리 양을 출력한다.
		System.out.println("남은 배터리 양 : "+battery);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		return Objects.equals(model, other.model);
	}
	
}
