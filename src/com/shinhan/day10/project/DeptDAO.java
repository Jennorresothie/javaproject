package com.shinhan.day10.project;

import java.util.*;

//Date Access Object
public class DeptDAO {
	
	private List<DeptVO> data = new ArrayList<>();
	
	// 모두 조회
	public List<DeptVO> selectALL() {
		// DB가서 data가져오기 select * from departments;
		return data;
	}
	
	//부서의 번호를 찾아서 반환
	public DeptVO selectById(int deptid){
		for(DeptVO vo : data) {
			if(vo.getDepartment_id() == deptid) return vo;
		}
		return null;
	}
	
	// 삽입
	public void insert(DeptVO vo) {
		data.add(vo);
	}
}
