package com.shinhan.day12;

public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		int max=0;
		String maxName =null;
		for(String s: array) {
			String name = null;
			int point=0;
			boolean flag = false;
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<s.length()-1;i++) {
				if('0'<=s.charAt(i)&&s.charAt(i)<='9') {
					point*=10;
					point+=s.charAt(i)-'0';
				}
				else {
					sb.append(s.charAt(i));
				}
			}
			name = sb.toString();
	
			if(max<point) {
				max=point;
				maxName = name;
			}
		}
		
		System.out.println("최고점수는 "+maxName+"님 "+max+"점 입니다." );
	}
}
