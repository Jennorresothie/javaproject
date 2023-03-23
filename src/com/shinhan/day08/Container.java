package com.shinhan.day08;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Container<T, K> {
	T input;
	K data;
	
	void set(T data, K k) {
		input = data;
		this.data = k;
	}
	
	T getKey() {
		return input;
	}
	
	K getValue() {
		return data;
	}
	
}
