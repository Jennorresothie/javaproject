package com.shinhan.day12;

// interface :  규격서, 반드시 규칙을 지켜야함
/*정의 되어 있는 추사에소드를 구현 class에서 받느시 구현해야한다
 * T는 제너릭 타입 : 사용 시에 결정
 * 람다표현식으로 가능한 interface이고자한다 => 추상메소드가 단 하나만 존재
 * 람다표현식이 아니라 구현이나 익명클래스로 만들어서 여러 추상메소드가 있어도 사용할 수 있다
 * */
public interface Function<T> {
	public double apply(T t);
}
