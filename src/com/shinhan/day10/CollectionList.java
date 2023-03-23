package com.shinhan.day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

import com.shinhan.day09.Account;

public class CollectionList {

	public static void main(String[] args) throws InterruptedException {
		f14();

	}
	
	private static void f16() {
		//수정 불가한 Collection
		Map<String, Integer> m = Map.of("김",30,"나",50,"박",70,"이",60);
		for(String key : m.keySet()) {
			System.out.println(key+" : "+m.get(key));
		}
		
	}

	private static void f15() {
		//수정 불가한 Collection
		//Set<Integer> s = Set.of(2,3,4,2,5);// 값 중복 불가!
		Set<Integer> s = Set.of(2,3,4,5);
		for(Integer i : s)
			System.out.println(i);
		
	}

	private static void f14() {
		//수정 불가한 Collection
		Integer[] arr = new Integer[] {100,88,99,77,66};
		List<Integer> L = List.copyOf(Arrays.asList(arr));
		// 배열을 list로 바꿈
		//List<int[]> L = Arrays.asList(arr);
		
		List<Integer> L2 = List.of(2,3,4,2,5);
		
		for(Integer i : L)
			System.out.println(i);
	}

	private static void f13() {
		Set<Fruit> d = new HashSet<>();
		d.add(new Fruit("사과", 100));
		d.add(new Fruit("배", 150));
		d.add(new Fruit("귤", 200));
		d.add(new Fruit("사과", 60));
		d.add(new Fruit("두리안", 500));
		
		for(Fruit b:d) {
			System.out.println(b);
		}
		
	}

	private static void f12() {
		Set<Board> d = new TreeSet<>();
		d.add(new Board(1, "회식", "e", "shin"));
		d.add(new Board(3, "안회식", "b", "shin"));
		d.add(new Board(2, "외부", "c", "shin"));
		d.add(new Board(4, "내부", "d", "shin"));
		d.add(new Board(5, "회식", "a", "shin"));
		
		for(Board b:d) {
			System.out.println(b);
		}
	}

	private static void f11() {
		TreeMap<String, Integer> t = new TreeMap<>();
		t.put("홍길동2", 88);
		t.put("홍길동2", 100); // 중복값 있으면 최신것으로 대체
		t.put("홍길동4", 88);
		t.put("홍길동5", 77);
		t.put("홍길동3", 66);
		t.put("홍길동1", 99);
		
		for(String key : t.keySet())
			System.out.println(key +" : "+ t.get(key));
		
		System.out.println("1번 키: "+t.firstKey());
		System.out.println("1번 : "+t.get(t.firstKey()));
		System.out.println("마지막 키: "+t.lastKey());
		System.out.println("마지막 : "+t.get(t.lastKey()));
		System.out.println("lowerEntry : "+t.lowerEntry("홍길동2"));
		
		NavigableMap<String, Integer> t2 = t.descendingMap();
		
		for(String key : t2.keySet())
			System.out.println(key +" : "+ t.get(key));
	}

	private static void f10() {
		TreeSet<Integer> s = new TreeSet<>();
		s.add(100);
		s.add(10);
		s.add(30);
		s.add(40);
		s.add(50);
		s.add(80);
		s.add(80);
		for(Integer j : s) {
			System.out.println(j);
		}
		System.out.println("1번 "+s.first());
		System.out.println("마지막 "+s.last());
		System.out.println("50초과 "+s.higher(50));
		System.out.println("50미만 "+s.lower(50));		
		System.out.println("50이상 "+s.ceiling(50));
		System.out.println("50이하 "+s.floor(50));
		
		NavigableSet<Integer> ss = (NavigableSet<Integer>) s.tailSet(50);
		for(Integer i : ss)
			System.out.println("50이상들 다 "+ i);
		
		ss = (NavigableSet<Integer>) s.headSet(50);
		for(Integer i : ss)
			System.out.println("50이하들 다 "+ i);
		
		
	}

	private static void f9() {
		Set<Account> tree = new TreeSet<>();
		tree.add(new Account("계좌","예금주5",100));
		tree.add(new Account("계좌2","예금주5",100));
		tree.add(new Account("계좌1","예금주4",100));
		tree.add(new Account("계좌3","예금주3",100));
		tree.add(new Account("계좌4","예금주2",100));
		tree.add(new Account("계좌4","예금주1",100));
		
		for(Account s: tree)
			System.out.println(s);
		
	}
	
	private static void f8() {
		Set<String> tree = new TreeSet<>();
		tree.add("월");
		tree.add("월2");
		tree.add("월1");
		tree.add("월4");
		tree.add("월3");
		tree.add("월5");
		tree.add("월5");
		for(String s: tree)
			System.out.println(s);
		
	}

	private static void f7() {
		Properties pro = new Properties();
		try {
			InputStream fi = new FileInputStream("src/com/shinhan/day10/oracle.properties");
			pro.load(fi);
			//pro.load(CollectionList.class.getResourceAsStream("oracle.properties"));
			String driver = pro.getProperty("myname");
			System.out.println(driver);
			
			for(Object key : pro.keySet()) {
				String value = pro.getProperty((String)key);
				System.out.println(key+" : "+value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void f6() {
		
	}

	private static void f5() {
		Set<Account> data = new HashSet<>();
		data.add(new Account("계좌", "예금주", 1000));
		data.add(new Account("계좌", "예금주", 1000));
		data.add(new Account("계좌1", "예금주", 1000));
		data.add(new Account("계좌2", "예금주", 1000));
		data.add(new Account("계좌3", "예금주", 1000));	
	
		// iterator
		Iterator<Account> it = data.iterator();
		
		while(it.hasNext()) {
			Account s = it.next();
			System.out.println(s);
		}
		
		// 원하는 객체 찾기
		Account acc = new Account("계좌", "예금주", 1000);
		boolean re = data.contains(acc);
		System.out.println(re?"찾음":"못찾음");
		
	}

	private static void f4() {
		List<Account> data = new LinkedList<>();
		long start = System.nanoTime();
		
		for(int i=1;i<100001;i++) {
			data.add(new Account(i+"","홍"+i,100));
		}
		
		for(int i=100;i<201;i++) {
			data.remove(i);
		}
		
		long end=System.nanoTime();
		DecimalFormat df = new DecimalFormat("###, ###");
		System.out.println("걸린시간 :"+df.format(end-start));
		
	}

	private static void f3() throws InterruptedException {
		List<Account> data = new Vector<>();
		long start = System.nanoTime();
		Thread t = new Thread() {

			@Override
			public void run() {
				for(int i=1;i<1001;i++) {
					data.add(new Account(i+"","홍"+i,100));
				}
			}
			
		};
		Thread t2 = new Thread() {
			
			@Override
			public void run() {
				for(int i=1001;i<2001;i++) {
					data.add(new Account(i+"","박"+i,100));
				}
			}
			
		};
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(data.size()+" 로그 개수");
		
		for(int i=1;i<101;i++) {
			data.remove(i);
		}
		
		long end=System.nanoTime();
		DecimalFormat df = new DecimalFormat("###, ###");
		System.out.println("걸린시간 :"+df.format(end-start));
	}

	private static void f2() {
		//ArrayList
		List<String> L = new ArrayList();
	
		L.add("자바");
		L.add("자바1");
		L.add("자바2");
		L.add("자바3");
		L.add("자바4");
		L.add("자바5");
		L.add("자바6");
		L.add("자바7");
		System.out.println(L.size()+"개");
		
		//일반 for
		for(int i=0;i<L.size();i++)
			System.out.println(i+"번째: "+L.get(i));
		
		// 향상된 for
		for(String s : L)
			System.out.println(s);
		
		for (Iterator iterator = L.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
	}

	private static void f() {
		//ArrayList
		List L = new ArrayList();
		L.add(100);
		L.add("자바");
		int a = (Integer)L.get(0);
		String b = (String)L.get(1);
		
	}

}
