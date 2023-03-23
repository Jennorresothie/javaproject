package com.shinhan.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		f2();

	}

	private static void f8() {
		List<Student2> st = new ArrayList<>();
		st.add(new Student2("김", "남", 90));
		st.add(new Student2("김", "여", 88));
		st.add(new Student2("박", "여", 77));
		st.add(new Student2("나", "남", 66));
		st.add(new Student2("이", "남", 55));
		st.add(new Student2("이", "여", 100));

		// group으로 집계를 하고 다시 group이 Collection으로 만든다.
		Map<String, Double> map = st.stream()
				.collect(Collectors.groupingBy(n -> n.getGender(), Collectors.averagingDouble(s -> s.getScore())));
		System.out.println(map);
	}

	private static void f7() {
		List<Student> st = new ArrayList<>();
		st.add(new Student("김", 90));
		st.add(new Student("김", 88));
		st.add(new Student("김", 77));
		st.add(new Student("김", 66));
		st.add(new Student("김", 55));
		st.add(new Student("김", 100));

		st.stream().sorted().forEach(s -> System.out.println(s));

	}

	private static void f6() {
		Integer[] arr = { 100, 88, 99, 55, 66 };
		Arrays.sort(arr); // Q 의미가 뭔가:
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr, (a, b) -> b - a);
		System.out.println(Arrays.toString(arr));

		Student[] arr2 = { new Student("김", 90), new Student("김", 88), new Student("김", 77), new Student("김", 66),
				new Student("김", 55), new Student("김", 100) };

		Arrays.sort(arr2, (a, b) -> a.getScore() - b.getScore());
		System.out.println("hay " + Arrays.toString(arr2));
	}

	private static void f5() {
		List<String> data = new ArrayList<>();
		data.add("This is java");
		data.add("I am a best developer");

		data.stream().flatMap(row -> Arrays.stream(row.split(" "))).forEach(w -> System.out.println(w));

		System.out.println("============================");

		for (String r : data) {
			String[] arr = r.split(" ");
			for (String s : arr)
				System.out.println(s);
		}
	}

	private static void f4() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김", 100));
		data.add(new Student("홍1", 50));
		data.add(new Student("박2", 40));
		data.add(new Student("나3", 30));
		data.add(new Student("이4", 20));
		data.add(new Student("김5", 10));

		data.stream().distinct().filter(s -> s.getName().startsWith("김")).mapToInt(a -> a.getScore()).average()
				.ifPresent(d -> System.out.println(d));
	}

	private static void f3() {
		// distinct : 중복 제거
		List<String> data = new ArrayList<>();
		data.add("홍길동1");
		data.add("홍길동1");
		data.add("홍길삼2");
		data.add("홍길삼2");
		data.add("홍동3");
		data.add("홍동3");
		data.add("홍동4");
		data.add("홍동4");
		data.add("홍길동5");
		data.stream().distinct().filter(s -> s.startsWith("길", 1)).forEach(n -> System.out.println(n));
	}

	private static void f2() throws IOException, URISyntaxException {
		// 방법 1
		FileInputStream f = new FileInputStream("data.txt");
		InputStreamReader reader = new InputStreamReader(f, "UTF-8");
		BufferedReader in = new BufferedReader(reader);
		int i;
		// i = f.read() 1byte 읽음
		while ((i = in.read()) != -1) { //
			System.out.print((char) i);
		}
	    System.out.println();

		// 방법 2
		Path p = Paths.get(StreamTest2.class.getResource("data.txt").toURI());
		System.out.println(p);
		Stream<String> streamdata = Files.lines(p, Charset.defaultCharset());
		streamdata.forEach(line -> System.out.println(line));
	}

	private static void f1() {
		// 숫자 범위로 스트림 얻기
		// 1~9
		IntStream.range(1, 10).forEach(n -> System.out.println(n + "***"));
		// 1~10
		IntStream.rangeClosed(1, 10).forEach(n -> System.out.println(n));
	}

	private static void f() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김", 100));
		data.add(new Student("김1", 50));
		data.add(new Student("김2", 40));
		data.add(new Student("김3", 30));
		data.add(new Student("김4", 20));
		data.add(new Student("김5", 10));
		// data를 stream으로 만들어서 중간처리, 최종 처리하고 싶다
		data.stream().forEach(st -> {
			System.out.println(st);
			System.out.println(st.getName() + "->" + st.getScore());
		});

		// 중간처리
		System.out.println("***************중간처리************");
		IntStream starr = data.stream().mapToInt(st -> st.getScore()); // Q mapToInt 의미 : int
		// starr.average().ifPresent() //Q 안되는 이유
		starr.average().ifPresentOrElse(a -> System.out.println(a), () -> System.out.println(" 학생이 없어요"));
		// double avg = starr.average().getAsDouble(); //Q에러나는 이유 : 이미 위 코드에서 다 사용해서 다시
		// 얻어와야한다. 사용하면 없어진다

		System.out.println();
	}

}
