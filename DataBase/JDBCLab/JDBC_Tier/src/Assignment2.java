import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import DAO.DeptDao;
import DAO.DeptDao2;
import DAO.EmpDao;
import DTO.Dept;
import DTO.Dept2;
import DTO.Emp;

/*
 App 서버 구성 (MVC 패턴) >> 웹
 잘하는 것만 해
 
 Model (java) >> DTO (데이터를 담을 수 있는 클래스 ) , DAO (데이터를 처리할 수 있는 클래스) , SERVICE
 								 							//	+) 서비스는 DAO와 DTO 를 처리해줌
 
 View (UI)    >> html, jsp 등등 >> 현재 console 화면제어 (main 정도) 
 
 Controller   >> 중앙제어자 (통제) >> 웹의 접근 통제 >> 모든 요청과 응답을 처리 >> JAVA >> Servlet(웹용 자바파일)
 								// +) 자바는 태생적으로 응용프로그램임. 웹을 못함. 그런 자바가 웹을 할 수 있게 해주는게 서블릿.  
 

 +) 컨서레 => 컨트롤러> 모델 {서비스>레포지토리(여기서는 dto, dao)}
 */

public class Assignment2 {

	public static void main(String[] args) throws ParseException {
		
		
		DeptDao2 dao = new DeptDao2();
		
		System.out.println("[전체조회]");
		
		List<Dept> deptlist = dao.getDeptAllList(); 

		if(deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println("[조건조회]");
		Dept dept = dao.getDeptListByDeptno(10);
		if(dept != null) {
			deptPrint(dept);
		}else {
			System.out.println("조건조회 FAIL");
		}
		
		
		System.out.println("[데이터 삽입]");
		Dept insertdept = new Dept();
		insertdept.setDeptno(100);
		insertdept.setDname("IT");
		insertdept.setLoc("SEOUL");
		
		int insertrow = dao.insertDept(insertdept);
		if(insertrow > 0 ) {
			System.out.println("INSERT ROW : " + insertrow);
		}else {
			System.out.println("INSERT FAIL");
		}
		
		System.out.println("[방금전 INSERT 한 데이터 조회]");
		deptlist = dao.getDeptAllList();
		if(deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println("[방금전 INSERT 한 데이터 수정]");
		Dept updatedept = new Dept();
		updatedept.setDeptno(100);
		updatedept.setDname("IT_UP");
		updatedept.setLoc("BUSAN");
		
		int updaterow = dao.updateDept(updatedept);
		if(updaterow > 0 ) {
			System.out.println("UPDATE ROW : " + updaterow);
		}else {
			System.out.println("UPDATE FAIL");
		}
		
		System.out.println("[방금전 UPDATE 한 데이터 조회]");
		deptlist = dao.getDeptAllList();
		if(deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println("[방금전 UPDATE 데이터 삭제하기]");
		int deleterow = dao.deleteDept(100);
		if(deleterow > 0 ) {
			System.out.println("DELETE ROW : " + deleterow);
		}else {
			System.out.println("DELETE FAIL");
		}
		
		System.out.println("[방금전 DELETE 한 데이터 조회]");
		deptlist = dao.getDeptAllList(); 
		if(deptlist != null) {
			deptPrint(deptlist);
		}
	 
	}
	


	public static void deptPrint(Dept dept) {
		System.out.println(dept.toString());
	}
	public static void deptPrint(List<Dept> list) {
		for(Dept data : list) {
			System.out.println(data.toString());
		}
	}

}
