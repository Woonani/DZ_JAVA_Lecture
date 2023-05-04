package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.Employee;
import DTO.EmployeeAndSal;
import DTO.Salary;
import UTILS.SingletonHelper;

public class SalaryDao {
	
	public void showAllSalaryList() {
		System.out.println("============================= 전체 급여목록 ==============================");
		List<Salary> sallist = getAllSalaryList();
		if(sallist.size() < 1) {
			System.out.println("데이터가 없습니다.");
		}else {			
			salPrint(sallist);
		}
		System.out.println("======================================================================");
		System.out.println();
	}
	
	public void showSalaryListByYYMM() {
		
		System.out.printf("조회할 급여 년도를 입력해주세요 : ");
		int year = Integer.parseInt(inputValue());
		System.out.printf("\n조회할 급여 월을 입력해주세요 : ");
		int month = Integer.parseInt(inputValue());
		LocalDate date = LocalDate.of(year, month, 25);
		System.out.println("\n================"+ year  +"년 "+month+"월 의 전체 급여목록 ================");
		List<Salary> sallist = getThisMonthSalary(date);
		if(sallist.size() < 1) {
			System.out.println("데이터가 없습니다.");
		}else {			
			salPrint(sallist);
		}
		System.out.println("======================================================================");
		System.out.println();
	}
	
	public void showSalEmpListByID() {
		
		System.out.println(" 부서아이디는 다음과 같습니다. 경영지원(10) 영업(20) IT(30) 인사(40)");
		System.out.printf("조회할 부서아이디를 입력해주세요 : ");
		int deptno  = Integer.parseInt(inputValue());
		System.out.printf("\n조회할 급여 년도를 입력해주세요 : ");
		int year = Integer.parseInt(inputValue());
		System.out.printf("\n조회할 급여 월을 입력해주세요 : ");
		int month = Integer.parseInt(inputValue());
		LocalDate date = LocalDate.of(year, month, 25);
		System.out.println();
		System.out.println("===================== 사원 /급여 정보 조회 내역 ============================");

		/*
		 "| 사원ID : " + employeeId + "| 사원이름 : " + employeeName 
				+ "| 직급ID : " + positionId +  "| 지급일 : " + paymentDate + "| 급여 : " + salary  + "|";
				
				DEPARTMENT_ID  
		 */
		// deptName으로 dept테이블에 id를 찾아서
		// 그걸로 emp + sal 조인인 테이블에서 걸러서 
		// 입력 월 데이터만 가져오기
		
		List<EmployeeAndSal> empSalList = new ArrayList<>();
		
		EmployeeAndSal empSal = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select e.EMPLOYEE_ID, e.EMPLOYEE_NAME, e.POSITION_ID, s.PAYMENT_DATE, s.SALARY"
					+ " from EMPLOYEES e join SALARIES s on e.EMPLOYEE_ID = s.EMPLOYEE_ID"
					+ " where e.DEPARTMENT_ID = ? and PAYMENT_DATE = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			pstmt.setDate(2, Date.valueOf(date));

			rs = pstmt.executeQuery();
			 
			while(rs.next()) {
				
				 empSal = EmployeeAndSal.builder()
							.employeeId(rs.getInt(1))
							.employeeName(rs.getString(2))
							.positionId(rs.getInt(3))
							.paymentDate(rs.getDate(4))
							.salary(rs.getInt(5))
							.build();
					
				empSalList.add(empSal);

			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		if(empSalList.size() < 1) {
			System.out.println("데이터가 없습니다.");
		}else {			
			empsalPrint(empSalList);
		}
		System.out.println("======================================================================");
		System.out.println();
		
		
	}
	
	//
	public void updateSalaryById() {
		System.out.printf("사원번호를 입력해주세요 : ");
		int empno = Integer.parseInt(inputValue());
		System.out.printf("\n급여 년도를 입력해주세요 : ");
		int year = Integer.parseInt(inputValue());
		System.out.printf("\n급여 월을 입력해주세요 : ");
		int month = Integer.parseInt(inputValue());
		LocalDate date = LocalDate.of(year,month,25);
		System.out.printf("\n급여액을 입력해주세요 : ");
		System.out.println();
		int sal = Integer.parseInt(inputValue());

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
		    String sql="update SALARIES set SALARY = ? where EMPLOYEE_ID =? and PAYMENT_DATE =?";
		    pstmt = conn.prepareStatement(sql);
		    
		    pstmt.setInt(1, sal);
		    pstmt.setInt(2, empno);
		    pstmt.setDate(3, Date.valueOf(date) );
		    result = pstmt.executeUpdate(); 
		    
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {

			SingletonHelper.close(pstmt);
		}
		
	
		if( result < 1 ) {
			System.out.println("error");
		}else {			
			System.out.println("수정되었습니다.");
		}
		System.out.println("======================================================================");
		System.out.println();
	}
	
	// 전체 사원의 전체 급여 목록 조회
	public List<Salary> getAllSalaryList(){
		List<Salary> sallist = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
		    String sql="select EMPLOYEE_ID , PAYMENT_DATE , SALARY from SALARIES order by PAYMENT_DATE desc";
		    pstmt = conn.prepareStatement(sql);

		    rs = pstmt.executeQuery(); 
		    while(rs.next()) {
		    	Salary sal = Salary.builder()
		    			.employeeId(rs.getInt(1))
		    			.paymentDate(rs.getDate(2))
						.salary(rs.getInt(3))
						.build();
		    	
		    	sallist.add(sal); //ArrayList 객체 담기 .... 5건  >> Dept 객체 5개 add
			   }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return sallist;
	}

	

	
	
	public List<Salary> getThisMonthSalary(LocalDate date ){ 
		List<Salary> sallist = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
		    String sql="select EMPLOYEE_ID , PAYMENT_DATE , SALARY from SALARIES where PAYMENT_DATE = ?";
		    pstmt = conn.prepareStatement(sql);
		    java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		    pstmt.setDate(1, sqlDate);
		    rs = pstmt.executeQuery(); 
		    
		    
		    while(rs.next()) {
		    	Salary sal = Salary.builder()
		    			.employeeId(rs.getInt(1))
		    			.paymentDate(rs.getDate(2))
						.salary(rs.getInt(3))
						.build();
		    	
		    	sallist.add(sal); 
			   }

		} catch (Exception e) {
			System.out.println("에러 : "+e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return sallist;
	}

//	// 전체 사원의 다음달 급여 insert 하기
//	public int insertAllSalary(String inputDate) { // insertDept(int deptno , String dname , String loc)
//		 List<Salary> sallist = getThisMonthSalary("2023/03/25");
//		 for (Salary sal : sallist) {
//				System.out.println("지난달 sallist" + sal.toString());
//		 }
//
//		 Connection conn = null;
//		 PreparedStatement pstmt=null;
//		 
//		 int rowcount = 0;
//		 int tempRowcount = 0;
//		 System.out.println("insertAllSalary try 전");
//		 
//		 try {
//			 conn = SingletonHelper.getConnection("oracle");
//			 String sql="insert into salaries(EMPLOYEE_ID, PAYMENT_DATE, SALARY) values(?,?,?)";
//			 pstmt = conn.prepareStatement(sql);
//			 for(Salary sal : sallist) {
//				pstmt.setInt(1, sal.getEmployeeId());
//				pstmt.setDate(2, Date.valueOf(inputDate));
//				pstmt.setInt(3, sal.getSalary());
//				if(pstmt.executeUpdate() >0) {
//					tempRowcount++;
//				}
//			 }
//			 List<Salary> sallist2 = getThisMonthSalary(inputDate);
//			 System.out.println("insertAllSalary 지난달 sallist"+sallist2.toString());
//
//			 rowcount = tempRowcount; 
//			 
//		 }catch (Exception e) {
//			 e.printStackTrace();
//			 System.out.println(e.getMessage());
//		 }finally {
//			 SingletonHelper.close(pstmt);
//		 }
//		 
//		 return rowcount;
//	}
	
	public void salPrint(List<Salary> sallist) {
		for (Salary sal : sallist) {
			System.out.println(sal.toString());
		}
	}
	public void empsalPrint(List<EmployeeAndSal> empSalList) {
		for (EmployeeAndSal empsal : empSalList) {
			System.out.println(empsal.toString());
		}
	}
	
	public String inputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
		
	}
}


/*
 //필요할까봐 메모
  // 전체 사원의 전체 급여 목록 조회
	public List<Salary> getAllMonthSalary(){
		List<Salary> sallist = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
		    String sql="select employeeId , paymentDate , salary from salaries";
		    pstmt = conn.prepareStatement(sql);
		    
//		    String sql="select employeeId , paymentDate , salary from salaries where paymentDate = ?";
//		    pstmt = conn.prepareStatement(sql);
//		    LocalDate date2 = LocalDate.of(2023, 3, 25);
//		    java.sql.Date sqlDate = java.sql.Date.valueOf(date2);
//		    pstmt.setDate(1, sqlDate);
		    rs = pstmt.executeQuery(); 
		    while(rs.next()) {
		    	Salary sal = Salary.builder()
		    			.employeeId(rs.getInt(1))
		    			.paymentDate(rs.getDate(2))
						.salary(rs.getInt(3))
						.build();
		    	
		    	sallist.add(sal); //ArrayList 객체 담기 .... 5건  >> Dept 객체 5개 add
			   }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return sallist;
	}
  
 */
 