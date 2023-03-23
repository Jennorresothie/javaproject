package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fruit implements Comparable<Fruit> {
	String name;
	int price;
	
	@Override
	public int compareTo(Fruit o) {
		int re= name.compareTo(o.name);
		if(re==0)
			return price-o.price;
		return re;
	}
}
