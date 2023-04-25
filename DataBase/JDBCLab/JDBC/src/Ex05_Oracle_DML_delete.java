import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05_Oracle_DML_delete {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null; // Statement라는 타입의 인터페이스
		
		try {
			//드라이버 로딩 생략
			
			// 연결객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			stmt = conn.createStatement(); // 생성된 객체를 Statement 타입의 인터페이스로 받음
			
			//DELETE
			int deptno=0;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("부서입력");
			deptno = Integer.parseInt(sc.nextLine());
			
			
			//delete from dmlemp where deptno=10
			// 전통적이고 고전적인 방법
			String sql = "delete from dmlemp where deptno=" + deptno; // 자동 commit
		    System.out.println(sql);
			
		    // 현재 vales(?,?,?)    >> ? 한개가 parameter한개를 뜻함. 들어온 값으로 ?를 채워주면 됨.
		    // executeUpdate() 함수 (insert, update, delete) 수행
		    
		    int resultrow = stmt.executeUpdate(sql);
		    
		    if(resultrow > 0) {
		    	System.out.println("성공 - 반영된 행의 수 : " + resultrow);
		    }else {
		    	System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다"); //else라고 해서 예외가 아님!!
		    }
		    
			
		} catch (Exception e) {
			// 문제발생 .... 고민 처리
			System.out.println("SQL 예외발갱 : " + e.getMessage());
		} finally {
			// 강제 실행 블럭 사용
			// 자원 해지
			try { // 엄격하게 쓰면 이렇게 가각 try- catch문 묶어줘야 함.
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
			
			try {
				conn.close();
			} catch (SQLException e3) {
				// TODO: handle exception
			}
			
			
		}
		
}
}
