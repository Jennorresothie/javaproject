package com.shinhan.day10.project;

import java.util.List;

//사용자의 요청을 받아서 Service에 전달, Service에 응답 결과를 View 통해 보여준다
public class DeptController {

	public static void main(String[] args) {
		DeptService service = new DeptService();
		
		DeptVO[] voarr = {new DeptVO(10, 123, 031, "개발부"),
				new DeptVO(20, 124, 031, "영업부"),
				new DeptVO(30, 125, 031, "총무부"),
				new DeptVO(40, 126, 031, "RH부"),
				new DeptVO(50, 127, 031, "R&D부")
				};
		
		for(DeptVO vo : voarr) {
			service.insert(vo);
		}
		
		//조회
		List<DeptVO> dl = service.selectALL();
		DeptView.print(dl);
		
		DeptVO search = service.seletByID(40);
		DeptView.print(search);
		
	}
}
