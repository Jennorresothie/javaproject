package com.shinhan.assign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.assign.VO.PostVO;
import com.shinhan.dbutill.OracleUtill;

public class PostDAO {
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int resultCount;

	// 글 전체 조회
	public List<PostVO> selectAll() {
		String sql = """
				select * from post_list
				""";

		List<PostVO> plist = new ArrayList<>();

		conn = OracleUtill.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				PostVO pv = makePost(rs);
				plist.add(pv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(rs, conn, pst);
		}

		return plist;

	}

	public PostVO selectOne(int n) {
		String sql = """
				select * from post_list where pono=?
				""";
		PostVO pv = null;

		conn = OracleUtill.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, n);
			rs = pst.executeQuery();

			while (rs.next()) {// 5 결과를 받는다
				pv = makePost(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(rs, conn, pst);
		}

		return pv;

	}

	// 글 등록
	public int insertPost(PostVO pv) {
		String sql = """
				insert into post_list values(pono.nextval, ?, ?, ?, ?, SYSDATE)
				""";

		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pv.getPoPhone());
			pst.setString(2, pv.getPoTitle());
			pst.setString(3, pv.getPoContent());
			pst.setInt(4, pv.getPost_Mem());

			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		return resultCount;
	}

	// 글 삭제
	public int deletePost(int index) {
		String sql = """
				delete from post_list where pono = ?
				""";

		conn = OracleUtill.getConnection();

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

	// 글 수정
	public int updatePost(int index, String content) {
		String sql = """
				update post_list
				set pocontent =?, post_date = SYSDATE
				where pono = ?
				""";

		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, content);
			pst.setInt(2, index);

			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}

		return resultCount;
	}

	// 글 삭제
	public int deleteMPost(int index, int mem) {

		String sql = """
				select post_mem from post_list where pono = ?
				""";

		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, index);
		
			rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)!=mem)
					resultCount=-1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		if(resultCount!=-1) {
			conn = OracleUtill.getConnection();
			
			String sql2 = """
					delete from post_list where pono = ?
					""";

			try {
				pst = conn.prepareStatement(sql2);
				pst.setInt(1, index);

				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				OracleUtill.dbDisconnection(null, conn, pst);
			}
		}

		return resultCount;
	}

	// 글 수정
	public int updateMPost(int index, String content, int mem) {
		String sql = """
				select post_mem from post_list where pono = ?
				""";

		conn = OracleUtill.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, index);
		
			rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)!=mem)
					resultCount=-1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}
		
		if(resultCount!=-1) {
			conn = OracleUtill.getConnection();
			
			sql = """
					update post_list
					set pocontent =?, post_date = SYSDATE
					where pono = ?
					""";

			conn = OracleUtill.getConnection();

			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, content);
				pst.setInt(2, index);

				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				OracleUtill.dbDisconnection(null, conn, pst);
			}
		}
		
		return resultCount;
	}

	private PostVO makePost(ResultSet rs2) throws SQLException {
		PostVO pv = new PostVO();

		pv.setPono(rs2.getInt("pono"));
		pv.setPoPhone(rs2.getInt("pophone"));
		pv.setPoTitle(rs2.getString("potitle"));
		pv.setPoContent(rs2.getString("pocontent"));
		pv.setPost_Mem(rs2.getInt("post_mem"));
		pv.setPost_Date(rs2.getDate("post_date"));

		return pv;
	}
}
