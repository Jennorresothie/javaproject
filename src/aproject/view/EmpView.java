package aproject.view;

import java.util.List;

import aproject.vo.EmpVO;

public class EmpView {
	
	public static void print(List<EmpVO> emplist) {
		System.out.println("==============직원 정보===============");
		System.out.println();
		
		for(EmpVO emp : emplist) {
			System.out.println(emp);
		}
		
		System.out.println();
	}
	
	public static void print(EmpVO emp) {
		System.out.println("==============직원 정보===============");
		System.out.println();
		
		if(emp==null) 
			print("해당 직원에 대한 정보가 없습니다.");
		
		else
			System.out.println(emp);
		
		System.out.println();
	}
	
	public static void print(String message) {
		
		System.out.println(" [알림] : "+message);
		
		System.out.println();
	}
	
	
	
	
}
