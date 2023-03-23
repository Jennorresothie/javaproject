package com.shinhan.day03;

public class Account {
	private String accNo;
	private int balance;
	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1000000;
	
	public Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo+" 계좌가 개설되었습니다.");
		System.out.println(accNo+" 계좌의 잔고는 "+ balance+"원입니다.");
	}
	
	public void withdraw(int input) {
		System.out.println(accNo+" 계좌에 "+ input +"원이 출금되었습니다.");
		if(balance-input>MIN_BALANCE)
			balance-=input;
		System.out.println(accNo+" 계좌의 잔고는 "+ balance+"원입니다.");
	}
	public void save(int input) {
		System.out.println(accNo+" 계좌에 "+ input +"원이 입금되었습니다.");
		if(balance+input<=MAX_BALANCE)
			balance+=input;
		System.out.println(accNo+" 계좌의 잔고는 "+ balance+"원입니다.");
	}
	public int getBalance() {
		return balance;
	}
	public String getAccNo() {
		return accNo;
	}
	
}
