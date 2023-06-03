package kr.or.kosa.dao;
/*
1. DB연결
2. CRUD 함수
3. 기본 5가지 + 알파 (조건검색 , 문자열 검색)
3.1 전체조회 , 조건조회 , insert , update , delete 함수

*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UTILS.SingletonHelper;
import kr.or.kosa.dto.Emp;


public class EmpDao {
		
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//1. 전체조회 >> select 결과 >> return multi row  (Dept 객체 여러개)
	//select deptno , dname , loc from dept
	public List<Emp> getEmpAllList(){
		
		//여러건의 데이터 (Dept 객체 여러개)
		List<Emp> emplist = new ArrayList<>();
		//deptlist.add(new Dept())
		
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			   String sql="select empno , ename , job , sal , hiredate from emp";
			   pstmt = conn.prepareStatement(sql);
			   rs = pstmt.executeQuery();
			   //POINT 여러건 데이터 담기 ^^
			   while(rs.next()) {
				   Emp emp = new Emp(); //하나의 row 를 담을 수 있는 DTO 객체 생성
				   emp.setEmpno(rs.getInt("empno"));
				   emp.setEname(rs.getString("ename"));
				   emp.setJob(rs.getString("job"));
				   emp.setSal(rs.getInt("sal"));
				   emp.setHiredate(rs.getDate("hiredate"));
				   emplist.add(emp); //ArrayList 객체 담기 .... 5건  >> Dept 객체 5개 add
			   }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return emplist;
	}
	
	
}
