package com.shinhan.day11;

import java.util.*;
import java.util.Map.Entry;

public class Review {
	public static void main(String[] args) {
		/* Collection : List Set 
		 * Map
		 * 
		 List: 순서 있고 중복 가능
		 Set: 순서 있고 중복 불가(중복 체크를 equals+hashcode()메소드 사용)
		 Map: Entry(키와 값), equals+hashcode()메소드 사용 값 비교, 
		 
		 List구현 class: ArrayLsit, Linkedlist, Vector(멀티스레드 안정적)
		 Set구현 class: HashSet, TreeSet
		 	Tree : data들어갈때 순서 정해짐(크기 비교가 가능해야함 compareTo()override )
		 Map구현 class: HashMap, TreeMap, Properties 
		*
		*/
		f();
	}

	private static void f() {
		List<Integer> l = new ArrayList<>();
		Set<Integer> s = new HashSet<>();
		Map<String, Integer> m = new HashMap<>();
		
		// 입력
		l.add(100);
		s.add(200);
		m.put("키", 100);
		
		// 조회
		System.out.println(l.get(0)); // list는 인덱스를 이용 할 수 있음
		System.out.println(s.iterator().next()); // Set은 순서가 없기 때문에 내부반복자를 이용하여 조회
			// it.next() 는 값을 가져옴, it.hasNext() 다음 값이 존재하는지 확인
		System.out.println(m.get("키")); // map은 key가 set으로 되어있음, key를 통해 value가져옴
		
		Set<String> keys = m.keySet(); // 모든 키 가져옴
		Set<Entry<String, Integer>> entry = m.entrySet(); // 모든 엔트리 가져옴
		Iterator<Entry<String, Integer>> it = entry.iterator();
		while(it.hasNext()) {
			Entry<String, Integer> en = it.next();
			System.out.println("key"+en.getKey()+"value"+en.getValue());
		}
		
	}
	
	
}
