package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student2 implements Comparable<Student2> {
	private String name;
	private String gender;
	private int score;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student 정보 [name=").append(name).append(", score=").append(score).append(", 성별=").append(gender).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student2 o) {
		
		return score - o.score;
	}
	
	
	
	
}
