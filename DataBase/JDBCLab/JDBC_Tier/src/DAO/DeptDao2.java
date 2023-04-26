package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import DTO.Dept2;
import UTILS.SingletonHelper;

public class DeptDao2 {
	
	//1. 전체조회 >> select 결과 >> return multi row  (Dept 객체 여러개)
	//select deptno , dname , loc from dept
	public List<Dept> getDeptAllList(){
		
		List<Dept> deptlist = new ArrayList<>();
		
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			   conn = SingletonHelper.getConnection("mariadb", "itworld", "super", "1004");
			   String sql="select deptno , dname , loc from dept";
			   pstmt = conn.prepareStatement(sql);
			   rs = pstmt.executeQuery();
			   while(rs.next()) {
				   Dept dept = new Dept(); 
				   dept.setDeptno(rs.getInt("deptno"));
				   dept.setDname(rs.getString("dname"));
				   dept.setLoc(rs.getString("loc"));
				   deptlist.add(dept); 
			   }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return deptlist;
	}
	
	//2. 조건조회 >> select 결과(where deptno=?) >> return single row (Dept 객체 한개)
	//select deptno , dname , loc  from dept where deptno=?
	public Dept getDeptListByDeptno(int deptno) {
	
		Dept dept = null; //
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("mariadb", "itworld", "super", "1004");
			String sql = "select deptno, dname, loc from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dept = new Dept(); // 하나의 row 담기 위한 객체
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return dept;
	}
	
	//3. 데이터 삽입 >> parameter (Dept 객체)  >>  return 정수
	//insert into dept(deptno,dname,loc) values(?,?,?)
	public int insertDept(Dept dept) { 
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("mariadb", "itworld", "super", "1004");
			 String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, dept.getDeptno());
			 pstmt.setString(2, dept.getDname());
			 pstmt.setString(3, dept.getLoc());
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
	public int updateDept(Dept dept) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 System.out.println(dept.toString());
		 try {
			 conn = SingletonHelper.getConnection("mariadb", "itworld", "super", "1004");
			 String sql="update dept set dname=? , loc=? where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dept.getDname());
			 pstmt.setString(2, dept.getLoc());
			 pstmt.setInt(3, dept.getDeptno());
			 
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
	public int deleteDept(int deptno) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("mariadb", "itworld", "super", "1004");
			 String sql="delete from dept where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, deptno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
}
