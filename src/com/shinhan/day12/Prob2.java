package com.shinhan.day12;

public class Prob2 {
	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		// 구현하시오.....return값 수정할것
		StringBuffer sb = new StringBuffer();
		try {
			int Size = str.length();
			size -= Size;
			if (size < 0) {
				throw new IllegalSizeException();
			}

			for (int i = 0; i < size; i++) {
				sb.append(fillChar);
			}
			sb.append(str);

		} catch (IllegalSizeException e) {
			e.printMessage();
		}

		return sb.toString();
	}
}

class IllegalSizeException extends RuntimeException {
	public IllegalSizeException() {
		super();
	}

	public void printMessage() {
		System.out.println("문자열의 길이보다 size가 큽니다.");
	}
}