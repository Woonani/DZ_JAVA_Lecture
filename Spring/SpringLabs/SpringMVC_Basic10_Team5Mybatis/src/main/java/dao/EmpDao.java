package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Emp;
import vo.Notice;

public interface EmpDao {
	// 전체emp
	List<Emp> getEmp() throws ClassNotFoundException, SQLException;
	
	// emp 검색
	List<Emp> getEmpByEname(String qname) throws ClassNotFoundException, SQLException;
	
	// emp 입력
    int insertEmp(Emp emp) throws ClassNotFoundException, SQLException; 
  	
    //emp 상세
    Emp selectEmpByEmpno(int empno) throws ClassNotFoundException, SQLException;

    
    //게시물 삭제
    int deleteEmp(int empno) throws ClassNotFoundException, SQLException;
    
    //게시물 수정
    int updateEmp(Emp emp) throws ClassNotFoundException, SQLException;
    

}
