package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of= {"title", "price"}) // 동등비교(원래는 주소 비교, 재정의 내용하고 가격비교)
public class Book<T> implements Comparable<Book>{ // class : 객체를 만들 틀, 비교하려고 Comparable 상속
	// instance 필드 맴버 : new해야 사용가능
	private T title; // 외부에서 함부로 변경 못하게 접근 지정자를 private
	private int price;
	private String publisher;
	private String[] author;
	
	private static int count; // new 안해도 사용 가능
	
	private static final String COMPANY="신한출판사"; // 상수,값 변경 불가능 선언할때 반드시 초기화 해야함
	
	
	public Book(T title, int price, String publisher, String[] author) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.author = author;
		count++;
	}

	@Override
	public int compareTo(Book o) {
		// 재정의, 가격으로 오름 차순
		return price-o.price;
	}
	
	public static <T> Book<T> makeBook(T title, int price) {
		return new Book<>(title, price, "홍대출판사", new String[] {"가가가","나나나"});
	}

	public static int getCount() {
		return count;
	}



	// Annotation으로 Getter, Setter 생성, toString 재정의, title하고 price로 같은 객체인지 비교
	
	
}
