package com.shinhan.assign.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shinhan.assign.VO.MemberVO;
import com.shinhan.assign.VO.PhoneVO;
import com.shinhan.assign.VO.PostVO;
import com.shinhan.assign.VO.TypeVO;
import com.shinhan.assign.model.AdminMemService;
import com.shinhan.assign.model.MemService;
import com.shinhan.assign.model.PhoneService;
import com.shinhan.assign.model.PostService;
import com.shinhan.assign.model.TypeService;
import com.shinhan.assign.view.MemberView;
import com.shinhan.assign.view.PhoneView;
import com.shinhan.assign.view.PostView;
import com.shinhan.assign.view.TypeView;

class who {
	static int Who;
}

public class TotalController {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		int re = front(sc);

		while (true) {

			if (re == -1)// 종료
				break;
			else if (re == 0) { // 관리자
				re = AdminMain(sc);
			} 
			else if (re>0) { // 일반 회원
				re = memMain(sc);
			}
			else // 메인 페이지
				re = front(sc);
		}

	}

	// 메인 화면
	private static int front(Scanner sc) {

		System.out.println("───────메인페이지────────");
		System.out.println("────────로그인──────────");
		System.out.println("────────회원가입─────────");
		System.out.println("─────────종료──────────");
		System.out.print("명령어 입력 : ");
		String command = sc.next();

		if (command.equals("종료")) {
			System.out.println("프로그램을 종료합니다.");
			return -1;
		}

		else if (command.equals("로그인")) {
			return login(sc);
		}

		else if (command.equals("회원가입")) {
			return signup(sc);
		}

		else {
			System.out.println("잘못된 입력입니다.");
			return -2;
		}
	}

	// 일반 회원 가입
	private static int signup(Scanner sc) {
		MemService ms = new MemService();
		int result;

		System.out.println("┌─────────────────────┐");
		System.out.println("│	 회원가입       │");
		System.out.println("└─────────────────────┘");

		System.out.print("전화번호, 닉네임 > ");
		String ID = sc.next();
		String nick = sc.next();

		result = ms.insertMem(nick, ID);

		System.out.println("결과 : " + result);

		MemberView.print(result >= 0 ? "회원가입 성공" : "회원가입 실패");

		return result;
	}

	// 관리자 가입
	private static int signup2(Scanner sc) {
		AdminMemService ams = new AdminMemService();
		int result;

		System.out.println("┌─────────────────────┐");
		System.out.println("│	 관리자 추가     │");
		System.out.println("└─────────────────────┘");

		System.out.print("전화번호> ");
		String ID = sc.next();

		MemberVO mv = new MemberVO();

		mv.setPhone_num(ID);

		result = ams.insertAMem(ID);

		MemberView.print(result >= 0 ? "회원가입 성공" : "회원가입 실패");

		return 0;
	}

	// 로그인
	private static int login(Scanner sc) {
		MemService ms = new MemService();
		List<Integer> list = new ArrayList<>();
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│	 로그인	      │");
		System.out.println("└─────────────────────┘");

		System.out.print("전화번호 > ");
		String ID = sc.next();
		list = ms.loginMem(ID);
		MemberView.print(list.get(1) >= 0 ? "로그인 성공" : "로그인 실패");
		
		who.Who=list.get(0);
		
		System.out.println(who.Who+"번호 로그인");
		
		return list.get(1);
		
	}

	// 관리자 페이지
	private static int AdminMain(Scanner sc) {

		System.out.println("──────관리자페이지──────");
		System.out.println("──────1.관리자추가──────");
		System.out.print("──────2-1.회원 조회──────");
		System.out.println("2-2.회원 삭제");
		System.out.print("──────3-1.유형 조회──────");
		System.out.print("3-2.유형 삽입──────");
		System.out.println("3-3.유형 삭제");
		System.out.print("──────4-1.번호 조회──────");
		System.out.print("4-2.번호 하나 조회───");
		System.out.print("4-3.번호 등록──────");
		System.out.print("4-4.번호 삭제──────");
		System.out.println("4-5.번호 수정");
		System.out.print("──────5-1.글 조회───────");
		System.out.print("5-2.글 하나 조회────");
		System.out.print("5-3.글 쓰기────────");
		System.out.print("5-4.글 삭제────────");
		System.out.println("5-5.글 수정");
		System.out.println("─────────종료──────────");
		System.out.print("명령어 입력 : ");
		String command = sc.next();
		
		int result=0;

		if (command.equals("종료")) {
			System.out.println("프로그램을 종료합니다.");
			return -1;
		}

		else if (command.equals("1")) {
			return signup2(sc);
		}

		else if (command.equals("2-1")) {
			AdminMemService ams = new AdminMemService();
			MemberView.print(ams.selectAll());
		}
		
		else if (command.equals("2-2")) {
			AdminMemService ams = new AdminMemService();
			System.out.print("삭제할 회원번호 입력 > ");
			int memid=sc.nextInt();
			result = ams.deleteMem(memid);
			MemberView.print(result>0? memid+"회원 삭제 성공" : memid+"회원 삭제 실패");
		}
		
		else if (command.equals("3-1")) {
			TypeService t = new TypeService();
			TypeView.print(t.selectAll());
		}
		
		else if (command.equals("3-2")) { // 유형 삽입
			TypeService t = new TypeService();
			System.out.print("삽입할 유형을 넣어주세요 :");
			String Type_name=sc.next();
			TypeVO ty = new TypeVO();
			ty.setTYPE_name(Type_name);
			TypeView.print(t.insertType(ty));
		}
		
		else if (command.equals("3-3")) { // 유형 삭제
			TypeService t = new TypeService();
			System.out.print("삭제할 유형 번호을 넣어주세요 :");
			int Type_no=sc.nextInt();
			TypeView.print(t.deleteType(Type_no));
		}
		
		else if (command.equals("4-1")) {
			PhoneService ps = new PhoneService();
			PhoneView.print(ps.selectAll());
		}
		
		else if (command.equals("4-2")) { // 번호 하나 조회
			PhoneService ps = new PhoneService();
			System.out.print("조회할 번호를 넣어주세요 :");
			String num=sc.next();
			PhoneView.print(ps.selectOne(num));
		}
		
		else if (command.equals("4-3")) { // 번호 등록
			PhoneService ps = new PhoneService();
			PhoneVO pv = new PhoneVO();
			System.out.print("등록할 전화번호, 이름, 유형을 입력해주세요: ");
			String num=sc.next();
			String name=sc.next();
			int t=sc.nextInt();
			pv.setPhName(name);
			pv.setPhone_num(num);
			pv.setType_kind(t);
			pv.setPost_mem(who.Who);
			PhoneView.print(ps.insertPh(pv));
		}
		
		else if (command.equals("4-4")) { // 번호 삭제
			PhoneService ps = new PhoneService();
			System.out.print("삭제할 번호를 넣어주세요 :");
			String num=sc.next();
			PhoneView.print(ps.deletePh(num));
		}
		
		else if (command.equals("4-5")) { // 번호 수정
			PhoneService ps = new PhoneService();
			System.out.print("수정할 번호 인덱스와 수정될 번호 넣어주세요 :");
			int n=sc.nextInt();
			String num=sc.next();
			PhoneView.print(ps.updatePh(n,num));
		}
		
		else if (command.equals("5-1")) {
			PostService ps = new PostService();
			PostView.print(ps.selectAll());
		}
		
		else if (command.equals("5-2")) { // 번호 하나 조회
			PostService ps = new PostService();
			System.out.print("조회할 게시글 번호를 넣어주세요 :");
			int n=sc.nextInt();
			PostView.print(ps.selectOne(n));
		}
		
		else if (command.equals("5-3")) { // 번호 등록
			PostService ps = new PostService();
			PostVO pv = new PostVO();
			System.out.print("게시할 전화번호의 인덱스, 제목을 입력해주세요: ");
			int n = sc.nextInt();
			String title = sc.nextLine();
			System.out.print("게시할 내용을 입력해주세요: ");
			String content = sc.nextLine();
			
			pv.setPoContent(content);
			pv.setPoPhone(n);
			pv.setPoTitle(title);
			pv.setPost_Mem(who.Who);
			
			PhoneView.print(ps.insertPost(pv));
		}
		
		else if (command.equals("5-4")) { // 번호 삭제
			PostService ps = new PostService();
			System.out.print("삭제할 게시글 번호를 넣어주세요 :");
			int n=sc.nextInt();
			PhoneView.print(ps.deletePost(n));
		}
		
		else if (command.equals("5-5")) { // 번호 수정
			PostService ps = new PostService();
			System.out.print("수정할 번호 인덱스와 수정될 내용을 넣어주세요 :");
			int n=sc.nextInt();
			String content=sc.nextLine();
			PhoneView.print(ps.updatePost(n,content));
		}

		else {
			System.out.println("잘못된 입력입니다.");
			return -2;
		}
		
		return 0;
	}

	// 회원 페이지
	private static int memMain(Scanner sc) {

		System.out.println("───────회원페이지───────");
		System.out.print("───────1-1.번호 검색───────");
		System.out.println("1-2.번호 등록");
		System.out.print("───────2-1.글 쓰기────────");
		System.out.print("2-2.글 하나 조회────────");
		System.out.print("2-3.글 삭제───────────");
		System.out.print("2-4.글 수정───────────");		
		System.out.println("2-5.글 조회");
		System.out.println("───────3.회원탈퇴─────────");
		System.out.println("─────────종료──────────");
		System.out.print("명령어 입력 : ");
		String command = sc.next();

		if (command.equals("종료")) {
			System.out.println("프로그램을 종료합니다.");
			return -1;
		}
		
		else if (command.equals("1-1")) { // 번호 하나 조회
			PhoneService ps = new PhoneService();
			System.out.print("조회할 번호를 넣어주세요 :");
			String num=sc.next();
			PhoneView.print(ps.selectOne(num));
		}
		
		else if (command.equals("1-2")) { // 번호 등록
			PhoneService ps = new PhoneService();
			PhoneVO pv = new PhoneVO();
			System.out.print("등록할 전화번호, 이름, 유형을 입력해주세요: ");
			String num=sc.next();
			String name=sc.next();
			int t=sc.nextInt();
			pv.setPhName(name);
			pv.setPhone_num(num);
			pv.setType_kind(t);
			pv.setPost_mem(who.Who);
			PhoneView.print(ps.insertPh(pv));
		}
		
		else if (command.equals("2-1")) { // 번호 등록
			PostService ps = new PostService();
			PostVO pv = new PostVO();
			System.out.print("게시할 전화번호의 인덱스, 제목을 입력해주세요: ");
			int n = sc.nextInt();
			String title = sc.nextLine();
			System.out.print("게시할 내용을 입력해주세요: ");
			String content = sc.nextLine();
			
			pv.setPoContent(content);
			pv.setPoPhone(n);
			pv.setPoTitle(title);
			pv.setPost_Mem(who.Who);
			
			PhoneView.print(ps.insertPost(pv));
		}
		
		else if (command.equals("2-2")) { // 번호 하나 조회
			PostService ps = new PostService();
			System.out.print("조회할 게시글 번호를 넣어주세요 :");
			int n=sc.nextInt();
			PostView.print(ps.selectOne(n));
		}
		
		else if (command.equals("2-3")) { // 번호 삭제
			PostService ps = new PostService();
			System.out.print("삭제할 게시글 번호를 넣어주세요 :");
			int n=sc.nextInt();
			PhoneView.print(ps.deleteMPost(n, who.Who));
			
		}
		
		else if (command.equals("2-4")) { // 번호 수정
			PostService ps = new PostService();
			System.out.print("수정할 번호 인덱스와 수정될 내용을 넣어주세요 :");
			int n=sc.nextInt();
			String content=sc.nextLine();
			PhoneView.print(ps.updateMPost(n,content, who.Who));
		}
		
		else if (command.equals("2-5")) {
			PostService ps = new PostService();
			PostView.print(ps.selectAll());
		}
		
		else if (command.equals("3")) {
			MemService ms = new MemService();
			System.out.print("정말 회원 탈퇴를 하시겠습니까? (y/n) > ");
			String str = sc.next();
			if(str.equals("y")) {
				int result = ms.deleteMem(who.Who);
				MemberView.print(result>0? "회원 탈퇴 성공" : "회원 탈퇴 실패");
			}
			else 
				System.out.println("탈퇴 되지 않았습니다.");
		}

		else {
			System.out.println("잘못된 입력입니다.");
			return -2;
		}
		
		return who.Who;
	}

}
