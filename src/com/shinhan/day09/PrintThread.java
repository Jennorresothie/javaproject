package com.shinhan.day09;

import java.util.Iterator;

public class PrintThread extends Thread {
	
	
	ShareArea share;
	public PrintThread(ShareArea share) {
		this.share = share;
	}
	
	@Override
	public void run() {
		for (int i =1; i<4; i++) {
			share.printBalance();
		}
	}
}
