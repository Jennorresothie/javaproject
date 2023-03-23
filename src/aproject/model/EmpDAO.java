package aproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;

import com.shinhan.dbutill.OracleUtill;

import aproject.vo.EmpVO;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeBINARY_DOUBLE;

//DAO : Data Access Object (DB에 대한 업무 = CURD를 하겠다 [DML])
public class EmpDAO {
	Connection conn; // 필드는 자동으로 초기화 되어서 null 필요없음.
	PreparedStatement pst; // 바인딩 변수('?') 지원함
	Statement st;
	ResultSet re;
	int resultCount; // insert, update, delete 건수
	
	//sp호출
	public EmpVO getSalary(int empid) {
		String sql = "{call 프로시저A(?,?,?)}";
		
		EmpVO emp = new EmpVO();
		
		conn = OracleUtill.getConnection();
		try {
			CallableStatement cst = conn.prepareCall(sql); //sp 지원
			cst.setInt(1, empid);
			cst.registerOutParameter(2, Types.DOUBLE);
			cst.registerOutParameter(3, Types.VARCHAR);
			
			cst.execute();
		
			emp.setSALARY(cst.getDouble(2));
			emp.setFIRST_NAME(cst.getString(3));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	public List<EmpVO> selectAll() {
		String sql = """
				select * from employees order by 1
				""";

		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtill.getConnection();

		try {
			st = conn.createStatement();
			re = st.executeQuery(sql);// 4 sql 실행문

			while (re.next()) {// 5 결과를 받는다
				EmpVO emp = makeEmp(re);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}

		return emplist;
	}

	public EmpVO selectById(int empid) {
		String sql = """
				select * from employees where employee_id = ?
				""";

		EmpVO emp = null;
		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, empid);
			re = pst.executeQuery();// 4 sql 실행문

			while (re.next()) {// 5 결과를 받는다
				emp = makeEmp(re);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, pst);
		}

		return emp;
	}

	public List<EmpVO> selectByDept(int deptid) {
		String sql = """
				select * from employees where department_id = ?
				""";

		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, deptid);
			re = pst.executeQuery();// 4 sql 실행문

			while (re.next()) {// 5 결과를 받는다
				EmpVO emp = makeEmp(re);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, pst);
		}

		return emplist;
	}

	public List<EmpVO> selectCodition(int deptid, String jobid, double salary) {
		String sql = """
				select * from employees where department_id = ? and job_id = ? and salary >= ?
				""";

		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, jobid);
			pst.setDouble(3, salary);
			re = pst.executeQuery();

			while (re.next()) {
				EmpVO emp = makeEmp(re);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, pst);
		}

		return emplist;
	}

	// 자신이 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원들을 조회
	public List<EmpVO> selectLowSal() {
		String sql = """
				SELECT e.employee_id, e.department_id, e.salary, e.first_name
				FROM employees e, ( select department_id, avg(salary) a from employees GROUP by department_id ) inlineview
				where e.department_id = inlineview.department_id and e.salary < inlineview.a
								""";

		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtill.getConnection();

		try {
			st = conn.createStatement();
			re = st.executeQuery(sql);// 4 sql 실행문

			while (re.next()) {// 5 결과를 받는다
				EmpVO emp = makeEmp2(re);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(re, conn, st);
		}

		return emplist;
	}

	// 신규직원등록
	public int empInsert(EmpVO emp) {
		String sql = """
				insert into employees values(SEQ_EMPLOYEE.nextval, ?,?,?,?,?,?,?,?,?,?)
				""";

		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFIRST_NAME());
			pst.setString(2, emp.getLAST_NAME());
			pst.setString(3, emp.getEMAIL());
			pst.setString(4, emp.getPHONE_NUMBER());
			pst.setDate(5, emp.getHIRE_DATE());

			pst.setString(6, emp.getJOB_ID());
			pst.setDouble(7, emp.getSALARY());
			pst.setDouble(8, emp.getCOMMISSION_PCT());
			pst.setInt(9, emp.getMANAGER_ID());
			pst.setInt(10, emp.getDEPARTMENT_ID());
			resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}

		return resultCount;
	}

	// 직원 정보 수정
	public int empUpdate(EmpVO emp) {
		String sql = """
				update employees
				set EMAIL = ?, DEPARTMENT_ID =?, JOB_ID=?, SALARY=?
				where EMPLOYEE_ID = ?
									""";

		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, emp.getEMAIL());
			pst.setInt(2, emp.getDEPARTMENT_ID());
			pst.setString(3, emp.getJOB_ID());
			pst.setDouble(4, emp.getSALARY());
			pst.setInt(5, emp.getEMPLOYEE_ID());
			
			resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}

		return resultCount;
	}
	
	// 직원 삭제
	public int empDelete(int empid) {
		String sql = """
				delete from employees
				where EMPLOYEE_ID = ?
									""";

		conn = OracleUtill.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, empid);
			
			resultCount = pst.executeUpdate();// DML문장 실행, 영향 받은 건수가 RETURN

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtill.dbDisconnection(null, conn, pst);
		}

		return resultCount;
	}

	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCOMMISSION_PCT(rs.getDouble("COMMISSION_PCT"));
		emp.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
		emp.setEMAIL(rs.getString("EMAIL"));
		emp.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
		emp.setFIRST_NAME(rs.getString("FIRST_NAME"));
		emp.setHIRE_DATE(rs.getDate("HIRE_DATE"));
		emp.setJOB_ID(rs.getString("JOB_ID"));
		emp.setLAST_NAME(rs.getString("LAST_NAME"));
		emp.setMANAGER_ID(rs.getInt("MANAGER_ID"));
		emp.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
		emp.setSALARY(rs.getDouble("SALARY"));

		return emp;
	}

	private EmpVO makeEmp2(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();

		emp.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
		emp.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
		emp.setFIRST_NAME(rs.getString("FIRST_NAME"));
		emp.setSALARY(rs.getDouble("SALARY"));

		return emp;
	}
}
