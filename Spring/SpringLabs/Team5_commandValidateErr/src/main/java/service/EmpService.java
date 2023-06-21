package service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import vo.Emp;

@Service
public class EmpService {
	// CustomerService 는 SqlSessionTemplate 에 의존합니다
	// SqlSessionTemplate 구현하는 인터페이스 SqlSession

	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	// 글목록보기 서비스
	public List<Emp> getLists() {

		// DAO 작업 예외 throws ClassNotFoundException, SQLException
		List<Emp> list = null;
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////

			list = empdao.getEmp();
			//System.out.println("list : " + list.get(0));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public List<Emp> getListByEname(String qname) {
		List<Emp> list = null;
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////
			
			list = empdao.getEmpByEname(qname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//System.out.println("EmpService 진입 ===================");
	
	public int addEmp(Emp emp) {
		int result = 0;
		try { 
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			result = empdao.insertEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} 
	
	public Emp empEdit (String empno) {
		Emp emp = null;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			emp = empdao.selectEmpByEmpno(Integer.parseInt(empno));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	////////////////////////////////////////
	public void setEmp (Emp emp) {
		int result = 0;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			result = empdao.updateEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	public void empDelete (int empno) {
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			empdao.deleteEmp(empno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
