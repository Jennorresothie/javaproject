package com.shinhan.day12;

public class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}


class PhoneCharge {
	private String user; //폰사용자이름
	private int call; //통화시간(분단위)
	private int sms; //문자전송건수
	private int data; //데이터통신량(GB단위)
	private int total; //통신요금(원) 
	
	public PhoneCharge (String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharge() {
		int callFee;//통화요금
		if(call>=200) {
			callFee = this.call*20;
		}
		else callFee = this.call*10;
		
		int smsFee; //문자요금
		if(sms>=300) {
			smsFee = this.sms*80;
		}
		else smsFee = this.sms*20;
		
		int dataFee; //데이터통신요금
		if(data>=7) {
			dataFee = this.data*2000;
		}
		else dataFee = this.data*1000;
		
		total = callFee + smsFee + dataFee;
		
		return total; 
	} 
	
	public void printCharge() {
		System.out.println(user+" 사용자는 이번달에 사용하신 전화요금이 "+calcCharge()+" 원입니다.");
	}  
	
}