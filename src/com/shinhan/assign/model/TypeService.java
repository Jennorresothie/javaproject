package com.shinhan.assign.model;

import java.util.List;

import com.shinhan.assign.VO.TypeVO;

public class TypeService {
	TypeDAO tDAO = new TypeDAO();
	
	public List<TypeVO> selectAll(){
		return tDAO.selectAll();
	}
	
	public String insertType(TypeVO ty) {
		int result = tDAO.insertType(ty);
		return result>0 ? "입력 성공" : "입력 실패";
	}
	
	public String deleteType(int index) {
		int result = tDAO.deleteType(index);
		return result>0 ? "삭제 성공" : "삭제 실패";
	}
}
