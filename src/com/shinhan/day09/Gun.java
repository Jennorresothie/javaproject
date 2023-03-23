package com.shinhan.day09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gun {
    static int AnswerN;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input4.txt"));
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int k=0; k<testCase; k++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			char[][] arr = new char[row][col];
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					arr[i][j] = sc.next().charAt(0);
					//System.out.print(arr[i][j]);
				}
				//System.out.println();
			}
			//구현하시오  
			
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					if('G'==arr[i][j]) 
						find(i,j, row, col, arr);
				}
				
			}
			
			
			System.out.println("#" + k + ":" + AnswerN);
			AnswerN=0;
		}
		
	}
	private static void find(int x, int y, int sizeX, int sizeY, char[][] arr) {
		int direc[][] = {{0,-1},{0,1},{-1,0},{1,0}};
		
		for(int i=0;i<4;i++) {
			int dx = x+direc[i][0];
			int dy = y+direc[i][1];
			
			while(true) {
				if(dx<0||dx>=sizeX||dy<0||dy>=sizeY)
					break;
				if(arr[dx][dy]=='T') {
					Gun.AnswerN++;
					arr[dx][dy]='0';
					break;
				}
				else if (arr[dx][dy]=='G'||arr[dx][dy]=='W')
					break;
				dx+=direc[i][0];
				dy+=direc[i][1];
			}
		}
		
	}
	
}
