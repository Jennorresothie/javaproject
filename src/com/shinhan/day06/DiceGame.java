package com.shinhan.day06;

public class DiceGame {

	public static void main(String[] args) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
		try {

			int result2 = game.countSameEye(-10);
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	int countSameEye(int n) {
		int count = 0;

		if (n < 0)
			throw new IllegalArgumentException("잘못된 수 입니다");

		for (int i = 0; i < n; i++) {
			Dice d1 = new Dice(8);
			Dice d2 = new Dice(8);

			int a = d1.play();
			int b = d2.play();

			if (a == b) {
				System.out.println("a: " + a + " b: " + b);
				count++;
			}
		}

		return count;

	}

}
