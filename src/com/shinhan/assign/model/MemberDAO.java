package com.shinhan.assign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.assign.VO.MemberVO;
import com.shinhan.dbutill.OracleUtill;


public class MemberDAO {
	Connection conn; // 필드는 자동으로 초기화 되어서 null 필요없음.
	PreparedStatement pst; // 바인딩 변수('?') 지원함
	Statement st;
	ResultSet re;
	int resultCount; // insert, update, delete 건수
	
	// 관리자, 회원 - 로그인
	public List<Integer> loginMem(String num) {
		List<Integer> who = new ArrayList<>();
		who.add(0);
		who.add(-2);
		
		String sql = """
				select MEMID, 등급  from Member_List where MEMPHONE = ?
				""";
		
		conn=OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, num);
			
			re = pst.executeQuery();
			
			if(re.next()) {
				int id = re.getInt("MEMID");
				int level = re.getInt("등급");
				who.set(0, id);
				who.set(1,level);
				return who;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, pst);
		}
		
		return who;
	}
	
	// 관리자 - 회원 조회
	public List<MemberVO> selectAll(){
		String sql = """
				select * from Member_List
				""";
		
		List<MemberVO> memlist = new ArrayList<>();
		conn = OracleUtill.getConnection();
		
		try {
			st=conn.createStatement();
			re = st.executeQuery(sql);
			
			while (re.next()) {// 5 결과를 받는다
				MemberVO mv = makeMember(re);
				memlist.add(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}
		
		return memlist;
	}
	
	// 관리자 - 관리자 추가
	public int insertAMem(String num) {
		String sql ="""
				insert into Member_List values(memid.nextVAL, '관리자'||memid.currval, ?, 0)
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, num);
			
			resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN
		} catch (SQLIntegrityConstraintViolationException ex) {
			System.out.println("중복된 결과 값이 있습니다.");
			return -2;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		insertphone(num);
		
		return resultCount;
	}
	
	// 회원 - 회원 추가
	public int insertMem(String name, String num) {
			String sql ="""
					insert into Member_List values(memid.nextVAL, ?, ?, 1)
					""";
			
			conn = OracleUtill.getConnection();
			
			try {
				pst=conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, num);
				
				resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN
			} catch (SQLIntegrityConstraintViolationException ex) {
				System.out.println("중복된 결과 값이 있습니다.");
				return -2;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				OracleUtill.dbDisconnection(null, conn, pst);
			}
			
			insertphone(num);
			
			
			return resultCount;
		}
	
	// 관리자, 회원 - 회원 삭제
	public int deleteMem(int index) {
		String sql = """
				delete from Member_List where memid = ?
									""";
		
		conn=OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, index);
			
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		return resultCount;
	}
	
	private MemberVO makeMember(ResultSet re) throws SQLException {
		MemberVO mv = new MemberVO();
		
		mv.setMemID(re.getInt("memID"));
		mv.setNick(re.getString("NICK_NAME"));
		mv.setPhone_num(re.getString("MEMPHONE"));
		mv.set등급(re.getInt("등급"));
		
		return mv;
	}
	
	private void insertphone(String num) {
		String sql2 ="""				
				select memid from member_list where memphone = ?
				""";
		
		String sql ="""				
				insert into Phone_List values(phno.nextVAL, '맴버'||?, ?, 1, ?, SYSDATE)
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql2);
			pst.setString(1, num);
			
			re=pst.executeQuery();
			re.next();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, re.getInt(1));
			pst.setString(2, num);
			pst.setInt(3, re.getInt(1));
			
			pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
	}
}
