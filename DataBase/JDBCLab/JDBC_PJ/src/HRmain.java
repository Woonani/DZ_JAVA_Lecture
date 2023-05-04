import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import DAO.EmployeeDao;
import DAO.SalaryDao;
import DTO.Employee;
import DTO.Salary;

public class HRmain {

	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		SalaryDao salDao = new SalaryDao();
		/*
		// 1. 사원 정보 관리
		// 1.1 부서, 직급, 사원 데이터 읽기
		System.out.println("[사원 전체 조회]");

		List<Employee> emplist = empDao.getEmpAllList();

		if (emplist != null) {
			empPrint(emplist);
		} else {
			System.out.println("데이터가 없습니다.");
		}

		// 1.2 부서 아이디로 불러오기
		Employee emp = empDao.getEmpById(1004);
		System.out.printf("id가 1004인 사원정보\n" + emp.toString());

		// 1.3 사원의 아이디로 사원의 전화번호 수정하기
		Employee emp2 = empDao.updateEmpById(1004, "01012341234");
		System.out.println(emp2);

		
		*/
		// 2. 급여 정보 관리
		// 2.1 사원들의 이번달 급여일을 일괄 insert
		// 특정 달 급여목록 조회
//		String date = "2023/03/25";
//		salDao.getThisMonthSalary(date); //ok
		

		
		// 급여에 변동사항이 없다면 지난달 데이터를 기준으로 다음달 급여 목록 일괄 insert
//		int result = salDao.insertAllSalary("2023-12-25");
//		System.err.println("result" + result);
		//--------------------------------------------------------------------------------------
		
		
		// [ 사원관리 메뉴 ]
		// 1. 아래 정보의 신입사원 등록후 등록한 아이디로 조회 ( CREATE & READ)
		//| 사원ID : 2001| 사원이름 : 이루루| 주소 : 서울시 노원구 | 전화번호 : 01077778787| 입사일 : 2023-05-4| 부서ID : 30| 직급ID : 1| 부서장ID : 1004|
//		empDao.setEmployee();
		
		// 2. 사원 아이디로 사원정보 삭제 (DELETE)
//		empDao.deleteEmployeeById();
		
		// 3. 사원ID로 사원 정보 조회 (조건 READ)(함수만 구현)
//		System.out.println(empDao.getEmpById(2001).toString());
		
		// 4. 사원 이름으로 사원정보 조회 (조건 READ)
//		empDao.getEmpByName();
		
		// [ 급여관리 메뉴 ]
		// 1. 전체 급여목록 조회 (READ)
//		salDao.showAllSalaryList();
		
		// 2. 입력한 월의 급여목록 조회 (조건 READ)
//		salDao.showSalaryListByYYMM();
		
		// 3. 특정 사원의 급여를 수정 (UPDATE)
//		salDao.updateSalaryById();
		
		// 4. 사원정보를 포함한 특정 부서의 급여목록 조회 (JOIN을 사용한 조건 READ)
		salDao.showSalEmpListByID();
		

	}
	
	
	
	public static void empPrint(List<Employee> emplist) {
		for (Employee emp : emplist) {
			System.out.println(emp.toString());
		}
	}
	
	public static String inputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
		
	}

}
