package com.shinhan.day05;

public class Audio implements RemoteController{// 구현 class

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+"전원을 킨다");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+"전원을 킨다");
	} 
	
	public void display() {
		RemoteController.super.display();
		System.out.println("Audio은 기능 수정");
	}

}
