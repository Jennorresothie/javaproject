package com.shinhan.day06;

public class Button {
	// field
	private ClickListener listener;
	
	//method
	void setListener(ClickListener listener) {
		this.listener = listener;
	}
	
	
	
	// 내부 인터페이스
	static interface ClickListener{
		void onClick(); //정의만 있고 구현은 없다 
	}

}
