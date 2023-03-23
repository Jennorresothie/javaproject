package com.shinhan.day10.project;

import java.util.*;

// Service : Controllor가 요청한 정보를 DAO로 전달, DAO에서 응답 받은 내용을 Controller에서 전달
// DB와 상관없는 Business logic 수행
public class DeptService {
	private DeptDAO dao = new DeptDAO();
	
	public List<DeptVO> selectALL(){
		return dao.selectALL();
	}
	
	public DeptVO seletByID(int deptid){
		return dao.selectById(deptid);
	}
	
	public void insert(DeptVO vo){
		dao.insert(vo);
	}
}
