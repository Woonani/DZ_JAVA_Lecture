package DAO;
/*
1. DB연결
2. CRUD 함수
3. 기본 5가지 + 알파 (조건검색 , 문자열 검색)
3.1 전체조회 , 조건조회 , insert , update , delete 함수

*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.Emp;
import UTILS.SingletonHelper;

public class EmpDao {
	
	public Emp getEmpListBySal(int sal) {
		
		Emp emp = null; //
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;

		try {
			conn = SingletonHelper.getConnection("mariadb", "kosadb", "super", "1004");
			String sql = "call selec_by_EmpList(?)";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, sal);
			rs = cstmt.executeQuery();

			while (rs.next()) {
				emp = new Emp(); // 하나의 row 담기 위한 객체
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getInt("sal"));
				emp.setHiredate(rs.getDate("hiredate"));
				System.out.println(rs.getInt("empno") + "/" + rs.getString("ename") + "/" + rs.getInt("sal"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emp;
	}
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
			   conn = SingletonHelper.getConnection("oracle");
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
	
	//2. 조건조회 >> select 결과(where deptno=?) >> return single row (Dept 객체 한개)
	//select deptno , dname , loc  from dept where deptno=?
	public Emp getEmpListByEmpno(int empno) {
	
		Emp emp = null; //
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno , ename , job , sal , hiredate from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Emp(); // 하나의 row 담기 위한 객체
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getInt("sal"));
				emp.setHiredate(rs.getDate("hiredate"));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return emp;
	}
	
	//3. 데이터 삽입 >> parameter (Dept 객체)  >>  return 정수
	//insert into dept(deptno,dname,loc) values(?,?,?)
	public int insertEmp(Emp emp) { // insertDept(int deptno , String dname , String loc)
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into emp(empno,ename,job,sal,hiredate) values(?,?,?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, emp.getEmpno());
			 pstmt.setString(2, emp.getEname());
			 pstmt.setString(3, emp.getJob());
			 pstmt.setInt(4, emp.getSal());
			 pstmt.setDate(5,emp.getHiredate());
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	
	//4. 데이터 수정 >> parameter (Dept 객체)  >>  return 정수
    //update dept set dname=? , loc=? where deptno=?
	public int updateEmp(Emp emp) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 System.out.println(emp.toString());
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="update emp set ename=? , job=? , sal=? , hiredate=? where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, emp.getEmpno());
			 pstmt.setString(2, emp.getEname());
			 pstmt.setString(3, emp.getJob());
			 pstmt.setInt(4, emp.getSal());
			 pstmt.setDate(5,emp.getHiredate());
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//5. 데이터 삭제 >> parameter (deptno)  >>  return 정수	
	//delete from dept where deptno=?
	public int deleteEmp(int empno) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from emp where empno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, empno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//6. Like 검색 >> 이름검색
		public Emp getEmpByEname(String ename) {
		
			Emp emp = null; //
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = SingletonHelper.getConnection("oracle");
				String sql = "select empno , ename , job , sal , hiredate from emp where ename like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%"+ ename +"%");
				rs = pstmt.executeQuery();

				while (rs.next()) {
					emp = new Emp(); // 하나의 row 담기 위한 객체
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setSal(rs.getInt("sal"));
					emp.setHiredate(rs.getDate("hiredate"));

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}

			return emp;
		}
	
}
