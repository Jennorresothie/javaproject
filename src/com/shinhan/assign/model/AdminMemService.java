package com.shinhan.assign.model;

import java.util.List;

import com.shinhan.assign.VO.MemberVO;

public class AdminMemService {
	MemberDAO mDAO = new MemberDAO();

	// 관리자, 회원 - 로그인
	public List<Integer> loginMem(String num) {
		return mDAO.loginMem(num);
	}

	public List<MemberVO> selectAll() {
		return mDAO.selectAll();
	}

	// 관리자 - 관리자 추가
	public int insertAMem(String num) {
		return mDAO.insertAMem(num);
	}

	// 관리자, 회원 - 회원 삭제
	public int deleteMem(int index) {
		return mDAO.deleteMem(index);
	}
}
