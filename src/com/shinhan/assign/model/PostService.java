package com.shinhan.assign.model;

import java.util.List;

import com.shinhan.assign.VO.PostVO;

public class PostService {
	PostDAO pDAO = new PostDAO();
	
	public List<PostVO> selectAll(){
		return pDAO.selectAll();
	}
	
	public PostVO selectOne(int n) {
		return pDAO.selectOne(n);
	}
	
	public String insertPost(PostVO pv) {
		int re = pDAO.insertPost(pv);
		return re>0? "글 등록 성공" : "글 등록 실패";
	}
	
	public String deletePost(int index) {
		int re = pDAO.deletePost(index);
		return re>0? "글 삭제 성공" : "글 삭제 실패";
	}
	
	public String updatePost(int index, String content) {
		int re = pDAO.updatePost(index, content);
		return re>0? "글 수정 성공" : "글 수정 실패";
	}
	
	public String deleteMPost(int index, int mem) {
		int re = pDAO.deleteMPost(index, mem);
		return re>0? "글 삭제 성공" : "글 삭제 실패";
	}
	
	public String updateMPost(int index, String content, int mem) {
		int re = pDAO.updateMPost(index, content, mem);
		return re>0? "글 수정 성공" : "글 수정 실패";
	}
}
