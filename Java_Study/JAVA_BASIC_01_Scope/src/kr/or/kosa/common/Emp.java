package kr.or.kosa.common;

//@Data.어노테이션으로 쓰는거 > 롬복 라이브러리
//VO, DTO, DOMAIN
// 사원 1명의 데이터를 담을 수 있는 클래스
// 사원 1명 생성 : Emp emp = new Emp(7788, "홍길동", "IT",300);
// emp.getEname(); 호출하면
// 홍길동님의 데이터가 출력

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	

	public Emp( int empno, String ename, String job,  int sal) {
		super();
		// TODO Auto-generated constructor stub
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}

	

	// 우클릭 + source + Generater Getter and Setter ...
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename + "님"; // 간접할당의 장점 : 개발자가 필요한 코드 강제할 수 있다.
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
}
