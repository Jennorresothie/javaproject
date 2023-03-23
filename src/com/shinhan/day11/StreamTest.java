package com.shinhan.day11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day09.Account;

public class StreamTest {

	public static void main(String[] args) {
		
		

	}
	
	private static void f4() {
		// 병렬처리
	
		Account[] bank = { 
				new Account("1234","이름",1000),
				new Account("1233","이름",1000),
				new Account("1235","이름",1000),
				new Account("1236","이름",1000),
				new Account("1236","이름",1000),
				new Account("1236","이름",1000)
		};
		List<Account> d = Arrays.asList(bank);
		d.parallelStream().forEach(a->{
			System.out.println(a);
			System.out.println(Thread.currentThread().getName());
			System.out.println("!!!!!!");
			
		});
		
		d.forEach(a->System.out.println(a)); // 내부반복자
	}
	
	private static void f3() {
		//2. Set		
		Set<Account> bank = new HashSet<>();
		 
		bank.add(new Account("1234","이름",1000));
		bank.add(new Account("1233","이름",1000));
		bank.add(new Account("1235","이름",1000));
		bank.add(new Account("1236","이름",1000));
	
		bank.stream().forEach(a->System.out.println(a));
		
		// 외부 반복자 사용
		bank.forEach(a->System.out.println(a));
	}
	
	private static void f2() {
		//2. List		
		Account[] bank = { 
				new Account("1234","이름",1000),
				new Account("1233","이름",1000),
				new Account("1235","이름",1000),
				new Account("1236","이름",1000)
		};
		List<Account> d = Arrays.asList(bank);
		d.stream().forEach(a->System.out.println(a));
		
		// 외부 반복자 사용
		d.forEach(a->System.out.println(a));
	}

	private static void f() {
		//1. 배열
		int[] arr1 = new int[] {100,30,70,20,50};
		Arrays.stream(arr1).forEach(a->System.out.println(a));
		
		IntStream is = Arrays.stream(arr1); // original stream
		IntConsumer method = (a)-> System.out.println("a = "+a);
		is.forEach(method); // stream 활용
		
		String[] str = {"자바", "웹", "스프링", "스프링부트", "백엔드", "CI/CD", "K8S"};
		//1. 내부 반복자를 이용하자고 한다면 먼저 stream을 얻는다.
		Stream<String> st = Arrays.stream(str);
		//2. 내부 반복자로 값을 처리한다
		Consumer<String> method2 = (s)->{
			System.out.println("++++++ "+s);
		};
		st.forEach(method2);
		
		Account[] bank = { 
				new Account("1234","이름",1000),
				new Account("1233","이름",1000),
				new Account("1235","이름",1000),
				new Account("1236","이름",1000)
		};
		Arrays.stream(bank).forEach(a->System.out.println(a));
		
		
	}

}
