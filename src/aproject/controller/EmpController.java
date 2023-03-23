package aproject.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import aproject.model.EmpService;
import aproject.view.EmpView;
import aproject.vo.EmpVO;

public class EmpController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmpService s = new EmpService();
		
		while(true) {
			System.out.print("1. 모든 직원조회\t");
			System.out.print("2. 직원 상세조회\t");
			System.out.print("3. 부서의 직원조회\t");
			System.out.print("4. 부서, 직책, 급여로 조회\t");
			System.out.print("5. 부서별 평균보다 적게 받는 직원 조회\t");
			System.out.print("6. 직원 입력\t");
			System.out.print("7. 직원 정보 수정\t");
			System.out.println("8. 직원 삭제\t");
			System.out.println("원하는 작업의 번호를 입력하거나 종료를 원하면 \"종료\"라고 입력하십시오.");
			System.out.print("작업 선택 > ");
			
			String command = sc.next();
			if(command.equals("종료")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			switch (command) {
			case "1": {
				EmpView.print(s.selectAll());
				break;
			}
			case "2": {
				System.out.print("조회할 직원번호 >");
				int empid = sc.nextInt();
				EmpView.print(s.selectById(empid));
				break;
			}
			case "3": {
				System.out.print("조회할 부서번호 >");
				int deptid = sc.nextInt();
				EmpView.print(s.selectByDept(deptid));
				break;
			}
			case "4": {
				System.out.print("조회할 부서번호, job, 연봉 >");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				double salary = sc.nextDouble();
				EmpView.print(s.selectCodition(deptid, jobid, salary));
				break;
			}
			case "5": {
				List<EmpVO> emplist = s.selectLowSal();
				System.out.println(" [Controller 작업] : "+emplist.size());
				EmpView.print(emplist);
				break;
			}
			case "6": {
				EmpVO emp = makeEmp(sc);
				EmpView.print(s.empInsert(emp));
				break;
			}
			case "7": {
				System.out.print("수정할 직원 번호 > ");
				int empid = sc.nextInt();
				
				EmpVO emp = s.selectById(empid);
				
				if(emp==null) {
					EmpView.print(emp);
				}
				else {
					emp = updateEmp(sc, empid);
					EmpView.print(s.empUpdate(emp));
				}
				
				break;
			}
			case "8": {
				System.out.print("삭제할 직원번호 >");
				int empid = sc.nextInt();
				EmpVO emp = s.selectById(empid);
				
				if(emp==null) {
					EmpView.print(emp);
				}
				else {
					System.out.print("삭제를 진행하시겠습니까 ? (yes/no)");
					String yn = sc.next();
					if(yn.equals("yes"))
						EmpView.print(s.empDelete(empid));
				}
				break;
			}
			case "9": {
				System.out.print("조회할 직원번호 >");
				int empid = sc.nextInt();
				EmpVO emp = s.getSalary(empid);
				EmpView.print(emp.getFIRST_NAME()+"님의 급여는 "+emp.getSALARY()+"입니다.");
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + command);
			}
		}

	}

	private static EmpVO updateEmp(Scanner sc, int empid) {
		EmpVO emp = new EmpVO();
		
		System.out.print("수정할 직원의 email, 부서번호, jobid, 연봉 >");
		String email = sc.next();
		int deptid = sc.nextInt();
		String jobid = sc.next();
		double salary = sc.nextDouble();
		
		emp.setEMAIL(email);
		emp.setDEPARTMENT_ID(deptid);
		emp.setJOB_ID(jobid);
		emp.setSALARY(salary);
		emp.setEMPLOYEE_ID(empid);
		
		return emp;
	}

	private static EmpVO makeEmp(Scanner sc) {
		
		EmpVO emp = new EmpVO();
		
		System.out.print("등록할 직원 이름, 성, email, 전화 번호, jobId, 연봉, 커미션, 매니저 번호, 부서번호, 입사일(yyyy/mm/dd) >");
		String firstname = sc.next();
		String lastname = sc.next();
		String email = sc.next();
		String phone = sc.next();
		String jobid = sc.next();
		double salary = sc.nextDouble();
		double com = sc.nextDouble();
		int manager = sc.nextInt();
		int deptid = sc.nextInt();
		String sdate = sc.next();
		
		Date date = DateUtil.convertToDate(sdate);
		
		emp.setFIRST_NAME(firstname);
		emp.setLAST_NAME(lastname);
		emp.setEMAIL(email);
		emp.setPHONE_NUMBER(phone);
		emp.setJOB_ID(jobid);
		emp.setSALARY(salary);
		emp.setCOMMISSION_PCT(com);
		emp.setMANAGER_ID(manager);
		emp.setDEPARTMENT_ID(deptid);
		emp.setHIRE_DATE(date);
		
		return emp;
	}

}
