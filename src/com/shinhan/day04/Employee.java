package com.shinhan.day04;

public class Employee {
	private String name, title;
	private int baseSalary, totalSalary;
    
	public Employee(String name, String title, int baseSalary){
		this.name = name;
		this.title = title+"님";
		this.baseSalary = baseSalary;
		getTotalSalary();
	}
	
	 public void getTotalSalary() {
		 switch(title) {
		 case "부장님"-> totalSalary = baseSalary + (int)(baseSalary*0.25f);
		 case "과장님"-> totalSalary = baseSalary + (int)(baseSalary*0.15f);
		 default-> totalSalary = baseSalary + (int)(baseSalary*0.05f);
		 }
	 }
	 public void print() {
		 System.out.println(title+" 직급의 "
		 		+ name
		 		+ "의 본봉은 "
		 		+ baseSalary
		 		+ " 원이고 총급여는 "
		 		+ totalSalary
		 		+ " 원입니다");
	 }
}
