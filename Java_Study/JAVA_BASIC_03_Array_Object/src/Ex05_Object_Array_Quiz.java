import kr.or.kosa.dto.Emp;

public class Ex05_Object_Array_Quiz {
	public static void main(String[] args) {
		/*
		 사원 3명을 만드세요 
		 단 Array 사용하세요
		 사원의 정보
		 1000, 홍길동
		 2000, 김유신
		 3000, 유관순
		
		2. 개선된 for문으로 사번과 이름을 모두 출력하세요
		
		 */
		
//		Emp[] emps = new Emp[3];
//		emps[0] = new Emp(1000, "홀길동");
//		emps[1] = new Emp(2000, "김유신");
//		emps[2] = new Emp(3000, "유관순");
		
//		Emp[] emps = new Emp[] {new Emp(1000, "홀길동"),new Emp(2000, "김유신"),new Emp(3000, "유관순")}; 
		
		// 많이 쓰는 방법
		Emp[] emps = {new Emp(1000, "홀길동"),new Emp(2000, "김유신"),new Emp(3000, "유관순")}; 
		
		for(Emp emp : emps) {
			emp.empInfoPrint();
		}
		
	}
}
