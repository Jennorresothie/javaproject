package com.shinhan.assign.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {
	private int memID;
	private String Nick;
	private String phone_num;
	private int 등급;
}
