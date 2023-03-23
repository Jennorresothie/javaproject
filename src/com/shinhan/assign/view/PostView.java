package com.shinhan.assign.view;

import java.util.List;

import com.shinhan.assign.VO.PostVO;

public class PostView {
	public static void print(List<PostVO> plist) {
		System.out.println("============== 게시판 ===============");
		System.out.println();
		
		for (PostVO pv : plist) {
			System.out.println(pv);
		}
		System.out.println();
	}
	
	public static void print(PostVO pv) {
		if (pv == null)
			print("해당 게시글에 대한 정보가 없습니다.");
		else {
			System.out.println("============== "+ pv.getPoTitle() +" ===============");
			System.out.println();
			
			System.out.println(pv);
		}
		
		System.out.println();
	}

	private static void print(String message) {
		System.out.println(" [알림] : " + message);

		System.out.println();
		
	}
}
