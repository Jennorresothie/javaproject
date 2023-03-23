package com.shinhan.assign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.assign.VO.TypeVO;
import com.shinhan.dbutill.OracleUtill;


public class TypeDAO {
	Connection conn; // 필드는 자동으로 초기화 되어서 null 필요없음.
	PreparedStatement pst; // 바인딩 변수('?') 지원함
	Statement st;
	ResultSet re;
	int resultCount; // insert, update, delete 건수
	
	// 유형 조회
	public List<TypeVO> selectAll(){
		String sql = """
				select * from Type_List
				""";
		
		List<TypeVO> typelist = new ArrayList<>();
		conn = OracleUtill.getConnection();
		
		try {
			st=conn.createStatement();
			re = st.executeQuery(sql);
			
			while (re.next()) {// 5 결과를 받는다
				TypeVO ty = makeType(re);
				typelist.add(ty);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}
		
		return typelist;
	}
	
	// 유형 추가
	public int insertType(TypeVO ty) {
		String sql ="""
				insert into type_list values(type_no.nextval,?)
				""";
		
		conn = OracleUtill.getConnection();
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ty.getTYPE_name());
			
			resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		return resultCount;
	}
	
	// 유형 삭제
	public int deleteType(int index) {
		String sql = """
				delete from Type_List
				where TYPENO = ?
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
	
	private TypeVO makeType(ResultSet re) throws SQLException {
		TypeVO ty = new TypeVO();
		
		ty.setTYPE_name(re.getString("TYPE_name"));
		ty.setTypeNO(re.getInt("typeNO"));
		return ty;
	}
}
