package com.shinhan.day12;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

import com.shinhan.day09.Account;



public class IOTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		f4();

	}
	private static void f4() {
		
		
		
	}
	
	
	private static void f3() throws IOException, ClassNotFoundException {
		
		FileOutputStream fw = new FileOutputStream("serialize.dat"); // 확장자 상관없다
		ObjectOutputStream oos = new ObjectOutputStream(fw);
		
		oos.writeObject(new Account("1313", "이나경", 10000));
		oos.writeObject(new Account("1346","이채영", 8284));
		oos.writeObject(new Account("1255","노지선", 8772));
		
		oos.close();
		fw.close();
		
		FileInputStream fs = new FileInputStream("serialize.dat");
		ObjectInputStream ois = new ObjectInputStream(fs);
		
		Account st = (Account) ois.readObject(); // 형 변환 해줘야함
		System.out.println(st);
		st = (Account) ois.readObject(); 
		System.out.println(st);
		st = (Account) ois.readObject(); 
		System.out.println(st);
		
		fs.close();
	}
	
	private static void f2() throws IOException {
		
		Path p = Paths.get("src/com/shinhan/day12/scoredata.txt");
		Files.lines(p).forEach(line->{
			System.out.print(line.replaceAll("/", "\t"));
			String[] str = line.split("/");
			int total=0;
			for(int i=1;i<str.length;i++) {
				try {
					total += Integer.parseInt(str[i]);
				}catch(NumberFormatException ex){
					
				}
				
			}
			System.out.println("\t"+total+"\t"+total/(str.length));
			
		});
		
		
	}

	private static void f() throws IOException {
		//InputStream, OutputStream, Reader, Writer
		//FileInputStream, FileOutputStream, FileReader, FileWriter
		InputStream is = System.in; // 키보드 입력(표준입력)을 받겠다. 변경가능
		byte[] arr = new byte[100];
		int i = is.read(arr);
		System.out.println(i);
		System.out.println(Arrays.toString(arr));
		for(int j=0;j<i-2;j++) {
			System.out.println((char)arr[j]);
		}
	}

}
