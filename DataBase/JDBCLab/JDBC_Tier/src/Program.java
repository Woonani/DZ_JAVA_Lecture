import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import DAO.DeptDao;
import DAO.EmpDao;
import DTO.Dept;
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

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		Dept dept = new Dept();
		dept.setDeptno(100);
		dept.setDname("IT");
		dept.setLoc("SEOUL");
		System.out.println(dept.toString());
		
		Emp emp = new Emp(200, "김유신");
		System.out.println(emp.toString());
		*/
		
		
		
		
		DeptDao dao = new DeptDao();
		EmpDao dao2 = new EmpDao();
		
		System.out.println("[전체조회]");
		List<Emp> emplist = dao2.getEmpAllList(); //요청
		
		//화면구성
		if(emplist != null) {
			empPrint(emplist);
		}
		
		System.out.println("[조건조회]");
		Emp emp = dao2.getEmpListByEmpno(7934);
		if(emp != null) {
			empPrint(emp);
		}else {
			System.out.println("조건조회 FAIL");
		}
		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("[데이터 삽입]");
		Emp insertemp= new Emp();
		insertemp.setEmpno(123);
		insertemp.setEname("김라미");
		insertemp.setJob("예술가");
		insertemp.setSal(5000);
		insertemp.setHiredate(Date.valueOf("2023-5-30"));
		int insertrow = dao2.insertEmp(insertemp);
		if(insertrow > 0 ) {
			System.out.println("INSERT ROW : " + insertrow);
		}else {
			System.out.println("INSERT FAIL");
		}
//		
//		System.out.println("[방금전 INSERT 한 데이터 조회]");
//		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
//		if(deptlist != null) {
//			deptPrint(deptlist);
//		}
//		
//		System.out.println("[방금전 INSERT 한 데이터 수정]");
//		Dept updatedept = new Dept();
//		updatedept.setDeptno(100);
//		updatedept.setDname("IT_UP");
//		updatedept.setLoc("BUSAN");
//		
//		int updaterow = dao.updateDept(updatedept);
//		if(updaterow > 0 ) {
//			System.out.println("UPDATE ROW : " + updaterow);
//		}else {
//			System.out.println("UPDATE FAIL");
//		}
//		
//		System.out.println("[방금전 UPDATE 한 데이터 조회]");
//		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
//		if(deptlist != null) {
//			deptPrint(deptlist);
//		}
		
//		System.out.println("[방금전 UPDATE 데이터 삭제하기]");
//		int deleterow = dao2.deleteEmp(123);
//		if(deleterow > 0 ) {
//			System.out.println("DELETE ROW : " + deleterow);
//		}else {
//			System.out.println("DELETE FAIL");
//		}
		
		System.out.println("[이름검색]");
		Emp emp2 = dao2.getEmpByEname("라");
		if(emp2 != null) {
			empPrint(emp2);
		}else {
			System.out.println("조건조회 FAIL");
		}
		
//		System.out.println("[방금전 DELETE 한 데이터 조회]");
//		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
//		if(deptlist != null) {
//			deptPrint(deptlist);
//		}
	
	
		
		
		
		//main 함수가  UI 와 요청/응답 처리
		//결국 main 함수가 (view 와 controller 역할 제공)
		
		
		/*
		DeptDao dao = new DeptDao();
		
		System.out.println("[전체조회]");
		List<Dept> deptlist = dao.getDeptAllList(); //요청
		
		//화면구성
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
		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
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
		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
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
		deptlist = dao.getDeptAllList(); //변경된 데이터 다시 조회
		if(deptlist != null) {
			deptPrint(deptlist);
		}
	 */
	}
	
	public static void empPrint(Emp emp) {
		System.out.println(emp.toString());
	}
	public static void empPrint(List<Emp> list) {
		for(Emp data : list) {
			System.out.println(data.toString());
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
