package com.shinhan.assign.model;

import java.util.List;

import com.shinhan.assign.VO.PhoneVO;

public class PhoneService {
	PhoneDAO pDAO = new PhoneDAO();
	
	// 관리자 - 전체 조회
	public List<PhoneVO> selectAll(){
		return pDAO.selectAll();
	}
	
	// 관리자, 회원 - 하나 조회
	public PhoneVO selectOne(String num) {
		return pDAO.selectOne(num);
	}
	
	// 관리자, 회원 - 등록
	public String insertPh(PhoneVO pv) {
		int re = pDAO.insertPhone(pv);
		return re>0?"전화번호 등록 성공":"전화번호 등록 실패";
	}
	
	// 관리자, 회원 - 수정
	public String updatePh(int n, String num) {
		int re = pDAO.updatePhone(n, num);
		return re>0?"전화번호 수정 성공":"전화번호 수정 실패";
	}
	
	// 관리자 - 삭제
	public String deletePh(String num) {
		int re = pDAO.deletePhone(num);
		return re>0?"전화번호 삭제 성공":"전화번호 삭제 실패";
	}
}
