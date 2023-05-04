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
import DTO.Salary;
import UTILS.SingletonHelper;

public class EmployeeDao {
	// 사원 한명 추가
	public void setEmployee(){
		System.out.println("======================== 사원정보 추가 ========================");
		System.out.printf("사원번호를 입력해주세요 : ");
		int employeeId = Integer.parseInt(inputValue());
		System.out.printf("\n사원이름을 입력해주세요 : ");
		String employeeName = inputValue();
		System.out.printf("\n주소를 입력해주세요 : ");
		String address = inputValue();
		System.out.printf("\n전화번호를 입력해주세요 : ");
		String phoneNumber = inputValue();
		System.out.printf("\n입사 년도를 입력해주세요 : ");
		int year = Integer.parseInt(inputValue());
		System.out.printf("\n입사 월을 입력해주세요 : ");
		int month = Integer.parseInt(inputValue());
		System.out.printf("\n입사 일을 입력해주세요 : ");
		int day = Integer.parseInt(inputValue());
		LocalDate date = LocalDate.of(year, month, day);
		
		System.out.printf("\n부서ID를 입력해주세요 : ");
		int departmentId = Integer.parseInt(inputValue());
		System.out.printf("\n직급ID를 입력해주세요 : ");
		int positionId = Integer.parseInt(inputValue());
		// 부서장ID는 자동으로 넣어주기

		System.out.println();
		
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into EMPLOYEES (EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) "
					+ " values (?,?,?,?,?,?,?,(select MANAGER_ID from EMPLOYEES where DEPARTMENT_ID = ? and POSITION_ID = 2 ))";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, employeeId);
			pstmt.setString(2, employeeName);
			pstmt.setString(3, address);
			pstmt.setString(4, phoneNumber);
			pstmt.setDate(5, Date.valueOf(date));
			pstmt.setInt(6, departmentId);
			pstmt.setInt(7, positionId);
			pstmt.setInt(8, departmentId);
			rowcount = pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		
		if(rowcount >0) {
			// insert 가 성공하면 insert 했던 사원ID로 조회해서 insert된 로우 조회.
			emp = getEmpById(employeeId);
			System.out.println(emp.toString());
			System.out.println("사원정보를 등록 완료");
		}else {
			System.out.println("사원정보 등록에 실패하였습니다.");
		}
		
	}
	
	/*
	 // 사원 한명 추가
	public void setEmployee(){
		System.out.println("======================== 사원정보 추가 ========================");
		System.out.printf("사원번호를 입력해주세요 : ");
		int employeeId = Integer.parseInt(inputValue());
		System.out.printf("\n사원이름을 입력해주세요 : ");
		String employeeName = inputValue();
		System.out.printf("\n주소를 입력해주세요 : ");
		String address = inputValue();
		System.out.printf("\n전화번호를 입력해주세요 : ");
		String phoneNumber = inputValue();
		System.out.printf("\n입사 년도를 입력해주세요 : ");
		int year = Integer.parseInt(inputValue());
		System.out.printf("\n입사 월을 입력해주세요 : ");
		int month = Integer.parseInt(inputValue());
		System.out.printf("\n입사 일을 입력해주세요 : ");
		int day = Integer.parseInt(inputValue());
		LocalDate date = LocalDate.of(year, month, day);
		
		System.out.printf("\n부서ID를 입력해주세요 : ");
		int departmentId = Integer.parseInt(inputValue());
		System.out.printf("\n직급ID를 입력해주세요 : ");
		int positionId = Integer.parseInt(inputValue());
		System.out.printf("\n부서장ID를 입력해주세요 : ");
		int managerId = Integer.parseInt(inputValue());
		System.out.println();
		
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into EMPLOYEES (EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, employeeId);
			pstmt.setString(2, employeeName);
			pstmt.setString(3, address);
			pstmt.setString(4, phoneNumber);
			pstmt.setDate(5, Date.valueOf(date));
			pstmt.setInt(6, departmentId);
			pstmt.setInt(7, positionId);
			pstmt.setInt(8, managerId);
			rowcount = pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		
		if(rowcount >0) {
			// insert 가 성공하면 insert 했던 사원ID로 조회해서 insert된 로우 조회.
			emp = getEmpById(employeeId);
			System.out.println(emp.toString());
			System.out.println("사원정보를 등록 완료");
		}else {
			System.out.println("사원정보 등록에 실패하였습니다.");
		}
		
	} 
	 */
	
	// 전체리스트 불러오기
	public List<Employee> getEmpAllList(){
		
		List<Employee> emplist = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID from employees";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Employee emp = Employee.builder()
						.employeeId(rs.getInt(1))
						.employeeName(rs.getString(2))
						.address(rs.getString(3))
						.phoneNumber(rs.getString(4))
						.hireDate(rs.getDate(5))
						.departmentId(rs.getInt(6))
						.positionId(rs.getInt(7))
						.managerId(rs.getInt(8))
						.build();

				emplist.add(emp);

			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return emplist;
	}
	
	// 사원 이름으로 사원정보 조회
	public void getEmpByName(){
		System.out.printf("검색할 사원의 이름을 입력해주세요 : ");
		String employeeName = inputValue();	
		
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID "
					+ "from employees where EMPLOYEE_NAME = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				emp = Employee.builder()
						.employeeId(rs.getInt(1))
						.employeeName(rs.getString(2))
						.address(rs.getString(3))
						.phoneNumber(rs.getString(4))
						.hireDate(rs.getDate(5))
						.departmentId(rs.getInt(6))
						.positionId(rs.getInt(7))
						.managerId(rs.getInt(8))
						.build();
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		System.out.println(emp.toString());
		
	}
	
	// 아이디로 사원 조회
	public Employee getEmpById(int employeeId){
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID "
					+ "from employees where EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				emp = Employee.builder()
						.employeeId(rs.getInt(1))
						.employeeName(rs.getString(2))
						.address(rs.getString(3))
						.phoneNumber(rs.getString(4))
						.hireDate(rs.getDate(5))
						.departmentId(rs.getInt(6))
						.positionId(rs.getInt(7))
						.managerId(rs.getInt(8))
						.build();

			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return emp;
	}
	
	// 아이디로 사원의 전화번호 수정
	public Employee updateEmpById(int employeeId, String phoneNum){
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update employees set PHONE_NUMBER = ? where EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNum);
			pstmt.setInt(2, employeeId);
			rowcount = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		
		return getEmpById(employeeId);
	}
	
	// 사원ID로 사원정보 삭제
		public void deleteEmployeeById(){
			System.out.printf("삭제할 사원의 사원번호를 입력해주세요 : ");
			int employeeId = Integer.parseInt(inputValue());	
			System.out.println();
			System.out.println(getEmpById(employeeId).toString());
			System.out.println("위 사원 정보를 삭제하시겠습니까?  1.예  2.아니오");
			switch(inputValue()) {
			case "1" : 
				System.out.println();
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				int rowcount = 0;
				
				try {
					conn = SingletonHelper.getConnection("oracle");
					String sql = "delete from EMPLOYEES where EMPLOYEE_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, employeeId);
					rowcount = pstmt.executeUpdate(); 
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					SingletonHelper.close(pstmt);
				}
				
				if(rowcount >0) {
					System.out.println("사원정보 삭제 완료");
				}else {
					System.out.println("사원정보 삭제에 실패하였습니다.");
				}
				break;
			case "2" :
				System.out.println();
				break;
			default : System.out.println("올바른 번호를 입력해주세요");
			}
			
			
		}
		
	
		
	// 사원 목록 출력 함수
	public void empPrint(List<Employee> emplist) {
		for (Employee emp : emplist) {
			System.out.println(emp.toString());
		}
	}
	
	// input값 받는 함수
	public String inputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
		
	}
	
}
