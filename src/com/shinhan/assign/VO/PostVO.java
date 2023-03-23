package com.shinhan.assign.VO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class PostVO {
	private int pono;
	private int poPhone;
	private String poTitle;
	private String poContent;
	private int post_Mem;
	private Date post_Date;
}
