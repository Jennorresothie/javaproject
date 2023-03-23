package com.shinhan.day10.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptVO {
	private int department_id, manager_id, location_id;
	private String department_name;
	
}
