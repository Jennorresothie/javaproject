package com.shinhan.day05;

public class Television implements RemoteController{// 구현 class

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

}
