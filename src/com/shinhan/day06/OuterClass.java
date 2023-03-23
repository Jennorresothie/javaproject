package com.shinhan.day06;

public class OuterClass {
	// field
	int a=10; // instance field
	static int b=20; // static field
	
	// constructor
	
	// method
	void method() {
		System.out.println("OuterClass instance method");
	}
	static void method2() {
		System.out.println("OuterClass static method");
	}
	
	// block
	{
		// instance block
	}
	static {
		// static block
	}
	
	// inner class (class, instance, local)
	class InstanceInnerClass{
		String s1="InstanceInnerClass임";
		static String s2="InstanceInnerClass임";
		void method3() { System.out.println("InnerClass...instance method"); }
		static void method4() { System.out.println("InnerClass...static method"); }
	}
	static class StaticInnerClass{
		String s1="InstanceInnerClass임";
		static String s2="InstanceInnerClass임";
		void method3() { System.out.println("StaticInnerClass...instance method"); }
		static void method4() { System.out.println("StaticInnerClass...static method"); }
	}
	void f1() {
		class LocalClass{
			String s3="LocalClass임";
			static String s4="LocalClass static임";
			void method5() { 
				System.out.println("LocalClass...instance method");
				System.out.println(s3);
				System.out.println(s4);
				System.out.println("--------------------------------------");
			}
			static void method6() { 
				System.out.println("LocalClass...static method");
				//System.out.println(s3);
				System.out.println(s4);
				System.out.println("--------------------------------------");
			}
		}
		LocalClass local = new LocalClass();
		local.method5();
		local.method6();
	}
	
	
}
