package kr.or.kosa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 JDBC 작업 ( DB결정 )
 ex) 회원 테이블
 1. 전체 조회, 조건 조회, 삽입, 삭제, 수정
 각각의 작업을 할 때마다
 1. 드라이버 로딩
 2. 연결객체 생성 .... 자원 해제
 3. 반복적인 코드 ... 제거하고 생산성 높을 수 있다. (> 생산성 : 유지보수의 편리성)
 
 공통적인 작업 별도 분리 ... 기능이 많이 사용되면 ..
 기능(함수) >> 자주( static ) >> overloading (편하게) >> 다형성 (유연하게)
 
 
 */
public class ConnectionHelper {

	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
				// conn인터페이스 리턴
			} else if (dsn.equals("mariadb")) {
//				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/team5","root","1004");
				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb","kosa","1004");
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;

	}

	// 계정이 바뀌는 경우를 위한 오버로딩 
		public static Connection getConnection(String dsn,String id, String pwd) { 
			Connection conn = null;
			try {
				if(dsn.equals("oracle")) {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
					// conn인터페이스 리턴
				} else if (dsn.equals("mariadb")) {
					conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb",id,pwd);
					
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return conn;
			
		}
	
	// 계정이 바뀌는 경우를 위한 오버로딩 - dbn : database Name
	public static Connection getConnection(String dsn, String dbn, String id, String pwd) { 
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
				// conn인터페이스 리턴
			} else if (dsn.equals("mariadb")) {
				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/"+dbn,id,pwd);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
