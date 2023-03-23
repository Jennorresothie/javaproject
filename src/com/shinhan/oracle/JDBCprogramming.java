package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.dbutill.OracleUtill;

public class JDBCprogramming {

	public static void main(String[] args) {
		//f();
		f2();

	}

	private static void f2() {
		System.out.print("상사의 이름을 입력하세요 :");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement st = null; //Statement를 상속 받는 PreparedStatement는 ? 지원함 Statement는 지원안함 
		ResultSet re = null;

		String sql = """
				select employee_id, first_name, salary, hire_date
				from employees
				where manager_id =ANY(
				            select employee_id
				            from employees
				            where last_name = initcap(?) )
								"""; // ? : 바인딩 변수

		
		try {
			conn = OracleUtill.getConnection();// 
			st =conn.prepareStatement(sql);
			st.setString(1, name); // 첫 번째 ?에 name이 들어갈거야
			
			re = st.executeQuery();// 4 prepared된 sql문을 실행한다

			while (re.next()) {// 5 결과를 받는다
				int emid = re.getInt(1);
				String fname = re.getString(2);
				int sal = re.getInt(3);
				Date date = re.getDate(4);
				System.out.println(emid+"\t"+fname+"\t"+sal+"\t"+date);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}

	}

	private static void f() {
		Connection conn = null;
		Statement st = null;
		ResultSet re = null;

		String sql = """
				select  first_name,department_id, department_name , city
				from employees JOIN departments using(department_id) join locations using(location_id)
				where job_id in (select job_id from jobs where substr(job_title,-7) = initCap('MANAGER'))
				""";

		// 1 driver load
		try {
			conn = OracleUtill.getConnection();// 2 연결
			st = conn.createStatement(); // 3 sql문 보낼 통로
			re = st.executeQuery(sql);// 4 sql 실행문

			while (re.next()) {// 5 결과를 받는다
				String fname = re.getString(1);
				int deptid = re.getInt(2);
				String deptname = re.getString(3);
				String city = re.getString(4);
				System.out.printf("%s\t%d\t%s\t%s\n", fname, deptid, deptname, city);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}

	}

}
