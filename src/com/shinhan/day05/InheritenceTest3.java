package com.shinhan.day05;

class A {
	
}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}

public class InheritenceTest3 {

	public static void main(String[] args) {
		Animal a = new Animal();
		Cat c = new Cat();
		Dog d = new Dog();
		f1(a);
		f1(c);
		f1(d);
		
		A v1 = new D();
		v1 = (B)v1;
	}

	private static void f1(Animal ani) {
		ani.method();
		if(ani instanceof Dog) {
			Dog d = (Dog) ani;
			System.out.println("다시 개로 형변환");
		}
		else if(ani instanceof Cat) {
			Cat d = (Cat) ani;
			System.out.println("다시 고양이로 형변환");
		}
	}

}
