package com.shinhan.day09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareArea {
	Account lee;
	Account sung;
	
	void transfer() {
		synchronized (this) {
			int amount = this.lee.withdraw(100);
			System.out.println("lee계좌에서  "+ amount + "출금");
			
			//입금한다
			this.sung.deposit(amount);
			System.out.println("sung계좌에서  "+ amount + "입금");
		}
	}
	
	synchronized void printBalance() {
		System.out.println("잔액  "+ this.lee.getBalance() + "원");
		System.out.println("잔액  "+ this.sung.getBalance() + "원");
	}
}
