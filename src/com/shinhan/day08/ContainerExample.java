package com.shinhan.day08;

public class ContainerExample {

	public static void main(String[] args) {
		Container<String, String> container1 = makeContainer();
		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1+" "+job);
		
		Container<String, Integer> container2 = makeContainer();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2+" "+age);
	}
	
	private static <T, K> Container<T, K> makeContainer() {
		return new Container<T, K>();
	}
	

}
