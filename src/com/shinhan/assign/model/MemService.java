package com.shinhan.assign.model;

import java.util.List;

import com.shinhan.assign.VO.MemberVO;

public class MemService {
	MemberDAO mDAO = new MemberDAO();
	
	//회원 - 로그인
	public List<Integer> loginMem(String num) {
		return mDAO.loginMem(num);
	}
	
	// 회원 - 회원 추가
	public int insertMem(String name, String num) {
		return mDAO.insertMem(name, num);
	}
	
	// 관리자, 회원 - 회원 삭제
	public int deleteMem(int index) {
		return mDAO.deleteMem(index);
	}
}
