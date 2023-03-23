package com.shinhan.day11;

import java.util.function.*;

import com.shinhan.day09.Account;

public class LamdaTest {

	public static void main(String[] args) {
		
		f13();
		

	}
	private static void f13() {
		BiFunction<String, String, Account> f = (a,b)->{
			System.out.println("계좌번호:"+ a);
			System.out.println("계좌주:"+ b);
			return new Account(a,b);
		};
		
		Account acc = f.apply("12346", "이새롬");
		System.out.println(acc);
		
		BiFunction<String, String, Account> f2 = Account::new;
		Account acc2 = f2.apply("14477", "이서연");
		System.out.println(acc2);
		
		
	}
	
	private static void f12() {
		BiFunction<Integer, Integer, Integer> f = (a,b)->{
			if(a>b) return a;
			return b;
		};
		System.out.println("큰값 " + f.apply(10, 20)); 
		
		BiFunction<Integer, Integer, Integer> f2 = (a,b)->Math.max(a, b);
		System.out.println("Math.max()사용한 큰값 " + f.apply(600, 20)); 
		
		BiFunction<Integer, Integer, Integer> f3 = Math::max;
		System.out.println("Math:::max()사용한 큰값 " + f.apply(600, 7000)); 

	}
	
	private static void f11() {
		// 표준 API의 함수적 인터페이스 사용
		// Predicate : 조사할 때 사용
		Predicate<Integer> f = (a)->a>10;
		System.out.println(f.test(100));
		
		Predicate<Account> f2 = (a)->{
			System.out.println(a);
			return a.getBalance()>=100000;
		};
		System.out.println(f2.test(new Account("123456","노지선",123456988)));
		
	}
	private static void f10() {
		// 표준 API의 함수적 인터페이스 사용
		// Operater : 매개값과 리턴값 모두 있는 추상 메소드 가짐
		// 주로 두 개의 값을 받고 결과를 리턴
		BinaryOperator<Integer> f = (a,b)->a+b;
		BinaryOperator<Integer> f2 = (a,b)->a*b;
		System.out.println(f.apply(2, 3));
		System.out.println(f2.apply(2, 3));

	}
	
	private static void f9() {
		// 표준 API의 함수적 인터페이스 사용
		// Function(주는 값, 리턴 받을 값) : 매개값과 리턴값 모두 있는 추상 메소드 가짐
		// 주로 매개값을 리턴 값으로 매핑(casting)할 경우 사용
		Function<String, Account> f = (a)->new Account("계좌",a,987456);
		BiFunction<String, String, Account> f2 = (a,b)->new Account(a,b,987654321);
		
		System.out.println(f.apply("이나경"));
		System.out.println(f2.apply("계좌번호", "이채영"));
	}
	
	
	private static void f8() {
		// 표준 API의 함수적 인터페이스 사용
		// Supplier : 리터만 있는 것
		Supplier<String> f = ()->"자바";
		Supplier<String> f2 = ()->{
			System.out.print("문장이 여러개 일때 ");
			return "자바";
		};
		
		System.out.println( f.get());
		System.out.println( f2.get());
		
		Supplier<Account> f3 = ()->new Account("12345","홍길동",12345);
		System.out.println(f3.get());
		

	}
	
	private static void f7() {
		// 표준 API의 함수적 인터페이스 사용
		// Consumer
		Consumer<Integer> f = (a)->System.out.println(a+100);
		f.accept(50);
		
		Consumer<String> f2 = (a)->System.out.println(a+6000);
		f2.accept("초봉은 ");
		
		BiConsumer<String , Integer> f3 = (a,b)->{
			System.out.println("a = "+a);
			System.out.println("b = "+b);
		};
		f3.accept("자바 시험 점수", 100);
		
		Consumer<Account> f4 = (a)->{
			System.out.println(a);
			a.deposit(10000);
			System.out.println( a.withdraw(2000));
		};
		f4.accept(new Account("12345", "홍길동", 60000000));
	}
	
    static String str ="java";
	
	private static void f6(int num) { //지역 변수
		int su = 200;// 지역 변수
		
		//익명
		Calcul f = new Calcul() {
			public int calculate(int n, int m) {
				System.out.println("익명 구현 객체");
				return n+m+num+su;
			}
		};
		System.out.println(f.calculate(1, 7));
		
		//Lamda
		Calcul f2 = (a,b)->{
			System.out.println("람다 표현식"+str);
			return a+b+num+su;
		};
		System.out.println(f2.calculate(2, 3));
		
	}

	private static void f5() {
		Calcul f = (a,b)->a+b;
		Calcul f3 = (a,b)->{
			System.out.println("여러문장이면 {} 필요");
			System.out.println("반드시 return 사용");
			return a+b;
		};
		Calcul f2 = new Calcul() {
			public int calculate(int x, int y) {
				return x+y;
			}
		};
		
		int re = f.calculate(1, 2);
		int re2 = f2.calculate(2, 3);
		int re3 = f3.calculate(3, 4);
		System.out.println(re);
		System.out.println(re2);
		System.out.println(re3);
		
	}

	private static void f4() {
		Person p = new Person();
		p.action(new Workable() { // 익명 클래스 구현
			public void work(String s, String s2) {
				System.out.println("이름은 "+s);
				System.out.println("직업은 "+s2);
				System.out.println("======================");
			}
		});
		
		p.action((a,b)->{System.out.println(a+" ::: "+b);});
		p.action((a,b)->{
			System.out.println(a+" /// "+b);
			System.out.println(a+" /// "+b);}
		);
		
		Workable w = (a,b)->{
			System.out.println(a+" @@@ "+b);
			System.out.println(a+" @@@ "+b);
		};
		p.action(w);
		
//		p.action(s->System.out.println(s+" 말하기"));
//		p.action2(s);
		
	}

	
	private static void f3() {
		work(()->System.out.println("스레드"));
	}
	
	private static void work(Runnable r) {
		Thread t = new Thread(r);
		t.start();
	
	}

	private static void action() {
		//f.calcultor()
	}

	private static void f() {
		// 구현 class
		MyInterface m = new MyClassImplement();
		m.print();
		
		// 익명 class
		new MyInterface() {
			
			@Override
			public void print() {
				System.out.println("익명 class로 구현 방법 1...");
				
			}
		}.print();
		
		MyInterface m2 = new MyInterface() {
			
			@Override
			public void print() {
				System.out.println("익명 class로 구현 방법 2...");
				
			}
		};
		m2.print();
		
		// Lamda식 이용
		MyInterface c = ()->System.out.println("람다식 이용.....");
		c.print();
	
		Calculable c2 = (x,y)->System.out.println("합"+(x+y));
		System.out.println();c2.calculate(2, 3);
		
		
		
		
	}

}
