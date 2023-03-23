package com.shinhan.day09;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Comparable<Account>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	// 1.field
	private String accNo;
	private String owner;
	
	@Override
	public int hashCode() {
		return Objects.hash(accNo, balance, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNo, other.accNo) && balance == other.balance && Objects.equals(owner, other.owner);
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}

	private int balance;

	// 생성자
	public Account() {

	}
	
	public Account(String accNo, String owner) {
		this.accNo = accNo;
		this.owner = owner;
	}

	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}

	// 메서드
	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (amount > balance) {
			System.out.println("잔고부족");
			return 0;
		}
		balance -= amount;
		return amount;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		//
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int compareTo(Account o) {
		
		return owner.compareTo(o.owner)*-1;
	}

}
