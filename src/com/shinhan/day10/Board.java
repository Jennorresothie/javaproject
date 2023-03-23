package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of= {"subject","writer"})
public class Board implements Comparable<Board>{
	private int boradNo;
	private String subject, content, writer;
	
	@Override
	public int compareTo(Board o) {
		int result = subject.compareTo(o.subject);
		if (result==0) {
			int result2 = writer.compareTo(o.writer);
			if(result2==0) 
				return boradNo - o.boradNo;
			return result2;
		}
		return result;
	}
}
