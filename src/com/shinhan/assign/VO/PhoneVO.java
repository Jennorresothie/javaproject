package com.shinhan.assign.VO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PhoneVO {
	private int phNO;
	private String phName;
	private String phone_num;
	private int type_kind;
	private int post_mem;
	private Date date;
}
