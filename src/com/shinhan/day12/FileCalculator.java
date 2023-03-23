package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileCalculator {
	
	public static void main(String[] args) throws Exception {
		FileCalculator f = new FileCalculator();
		f.addCalculateResult("C://data.txt");
	}
	
	void addCalculateResult(String inputFileName) throws Exception{
		int sum=0, total=1;
		List<Integer> number = new ArrayList<>();
		FileReader fr = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line=br.readLine())!=null) {
			int n = Integer.parseInt(line);
			number.add(n);
			sum+=n;
			total*=n;
		}
		number.add(sum);
		number.add(total);
		br.close();
		fr.close();
		
		FileWriter fw = new FileWriter(inputFileName);
		PrintWriter pw = new PrintWriter(fw);
		
		for(Integer i: number) {
			pw.println(i);
		}
		
		pw.close();
		fw.close();
		
	}
	
}
