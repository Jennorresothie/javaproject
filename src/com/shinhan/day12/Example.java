package com.shinhan.day12;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class Example {
	static Student[] st = { new Student("김", 10, 10),
			new Student("박", 20, 20),
			new Student("이", 30, 60),
			new Student("윤", 100, 100),
			new Student("나", 60, 70)
	};

	public static void main(String[] args) {
		double engAvg = avg(s->s.getEngScore());
		double mathAvg = avg(s->s.getMathScore());
		System.out.println("======람다 표현식만 사용======");
		System.out.println("영어 평균: "+engAvg);
		System.out.println("수학 평균: "+mathAvg);
		
		engAvg = Arrays.stream(st).mapToInt(s->s.getEngScore()).average().orElse(0);
		mathAvg = Arrays.stream(st).mapToInt(s->s.getMathScore()).average().orElse(0);
		System.out.println("======stream만 사용======");
		System.out.println("영어 평균: "+engAvg);
		System.out.println("수학 평균: "+mathAvg);
		
		engAvg = avg2(s->s.getEngScore());
		mathAvg = avg2(s->s.getMathScore());
		System.out.println("======람다 표현식+stream 사용======");
		System.out.println("영어 평균: "+engAvg);
		System.out.println("수학 평균: "+mathAvg);
	}
	
	// 람다 표현식+stream
	private static double avg2(ToIntFunction<Student> f) {
		return Arrays.stream(st).mapToInt(f).average().orElse(0);
	}
	//람다 표현식만 사용
	private static double avg(Function<Student> f) {
		double re = 0;
		for(Student s : st) {
			double d = f.apply(s);
			re += d;
		}
		return re/st.length;
	}

}
