package com.shinhan.day03;

// class : object를 만드는 틀
// object : class를이용해서 만든 독립된 개체, instance(실체)

public class Spliting {

	public static void main(String[] args) {
		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS 멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for(int i=0; i<addrArr.length; i++){
		System.out.print(addrArr[i] + " ");
		}

	}

	private String[] split(String addr, char c) {
		int size = addr.length();
		String[] addrArr = new String[4];
		int arr = 0, st = 0;
		
		for(int i=0; i<size; i++) {
			if(addr.charAt(i)==c) {
				addrArr[arr]=addr.substring(st, i);
				st=i+1;
				arr++;
			}
			else if (i==(size-1)) {
				addrArr[arr]=addr.substring(st, i+1);
			}
		}
		
		return addrArr;
	}

}
