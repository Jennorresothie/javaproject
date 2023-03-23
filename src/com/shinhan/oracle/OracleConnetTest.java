package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager; // module-info 에 정보추가 되어야함
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnetTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql ="select * from EMPLOYEES";
		
		//1. driver load
		Class.forName("oracle.jdbc.driver.OracleDriver"); //jar 커넥션 파일 외부에서 가져고 연결드라이버 가져오기
		System.out.println("1. driver load 성공!");
		
		//2. connection
		String url,userid, pass;
		url="jdbc:oracle:thin:@localhost:1521:xe";
		userid="hr";
		pass="hr";
		Connection conn = DriverManager.getConnection(url, userid, pass); // 연결 정보 저장
		System.out.println("DB connection 성공");
		
		//3. statement를 통해서 sql 전송
		Statement st =  conn.createStatement(); //java.sql.Statement
		ResultSet rs = st.executeQuery(sql); // 보낸 요청보내고 결과값 받기 
		while(rs.next()) {
			System.out.println("사원 번호 : "+rs.getInt(1) + " |	 이름 : "+rs.getString(2)+ " |	 성 : "+rs.getString(3)+" 연봉 : "+rs.getInt("salary"));
		}
		// 자원 반납
		rs.close();
		st.close();
		conn.close();
	}

}
