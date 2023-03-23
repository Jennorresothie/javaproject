package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Car implements Comparable<Car> {
	String name;
	int price;
	
	@Override
	public int compareTo(Car o) {
		
		int result = price - o.price; //오름차순
		if (result==0) return o.name.compareTo(name);
		return result;
	}

}
