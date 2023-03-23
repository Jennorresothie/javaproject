package com.shinhan.assign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.assign.VO.PhoneVO;
import com.shinhan.dbutill.OracleUtill;

public class PhoneDAO {
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int resultCount;
	
	// 전화번호 조회
	public List<PhoneVO> selectAll(){
		String sql = """
				select * from phone_list
				""";
		List<PhoneVO> phlist = new ArrayList<>();
		conn = OracleUtill.getConnection();
		
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				PhoneVO pv = makePhone(rs);
				phlist.add(pv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(rs, conn, st);
		}
		
		return phlist;
		
	}
	
	// 하나만 조회
	public PhoneVO selectOne(String num) {
		PhoneVO pv = null;
		String sql = """
				select * from phone_list where phone_num = ?
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, num);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				pv = makePhone(rs);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(rs, conn, pst);
		}
		
		return pv;
	}
	
	// 등록
	public int insertPhone(PhoneVO pv) {
		
		String sql = """
				insert into phone_list values(phno.nextval, ?,?,?,?,SYSDATE)
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, pv.getPhName());
			pst.setString(2, pv.getPhone_num());
			pst.setInt(3, pv.getType_kind());
			pst.setInt(4, pv.getPost_mem());
			
			resultCount = pst.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException ex) {
			System.out.println("중복된 결과 값이 있습니다.");
			return -2;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		
		return resultCount;
	}
	
	// 삭제
	public int deletePhone(String num) {
		String sql = """
				delete from phone_list where phone_num = ?
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, num);
			
			resultCount = pst.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		return resultCount;
	}
	
	// 수정
	public int updatePhone(int index, String num) {
		
		String sql = """
				update phone_list 
				set phone_num =?, post_date = SYSDATE
				where phno = ?
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, num);
			pst.setInt(2, index);
			
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		return resultCount;
	}
	
	private PhoneVO makePhone(ResultSet rs) throws SQLException {
		PhoneVO pv = new PhoneVO();
		
		pv.setPhNO(rs.getInt("phno"));
		pv.setPhName(rs.getString("phname"));
		pv.setPhone_num(rs.getString("phone_num"));
		pv.setType_kind(rs.getInt("type_kind"));
		pv.setPost_mem(rs.getInt("post_mem"));
		pv.setDate(rs.getDate("post_date"));
		
		return pv;
	}
}
