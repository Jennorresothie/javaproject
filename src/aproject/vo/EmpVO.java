package aproject.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpVO {
	// javaBeans 기술 : 1.변수 접근 지정자는 private, 2. setter/gatter, 3. 기본생성자 필요
	private int EMPLOYEE_ID;   
	private String FIRST_NAME;      
	private String LAST_NAME;    
	private String EMAIL;         
	private String PHONE_NUMBER;      
	private Date HIRE_DATE;      
	private String JOB_ID;       
	private double SALARY;                
	private double COMMISSION_PCT;        
	private int MANAGER_ID;             
	private int DEPARTMENT_ID;           
}
