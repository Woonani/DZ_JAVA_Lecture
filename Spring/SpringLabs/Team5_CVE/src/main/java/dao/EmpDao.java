package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Emp;


//CRUD
public interface EmpDao {

	//전체 조회
	List<Emp> getEmp() throws ClassNotFoundException, SQLException;
	
	//사번으로 조회하기 사번으로 조회하기라서 EMP가 리턴타입이어야 되지만 그냥했음.
	Emp getEmpByEmpno(int empno) throws ClassNotFoundException, SQLException;
	
	//삽입
	int insert(Emp emp) throws ClassNotFoundException, SQLException;

	// 수정
	int update(Emp emp) throws ClassNotFoundException, SQLException;
	
	// 삭제
	int delete(int empno) throws ClassNotFoundException, SQLException;
	
	
	
}
