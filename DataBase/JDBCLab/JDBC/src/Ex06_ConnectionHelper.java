import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.or.kosa.utils.ConnectionHelper;

public class Ex06_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
//		conn = ConnectionHelper.getConnection("mariadb");
		
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName()); // throws SQLException
		System.out.println(conn.getMetaData().getDatabaseMinorVersion());
		System.out.println(conn.isClosed());
		ConnectionHelper.close(conn);
		System.out.println(conn.isClosed());
		
	    conn = ConnectionHelper.getConnection("oracle", "null", "HR", "1004");
	    System.out.println(conn.toString());
		// oracle.jdbc.driver.T4CConnection@6cd28fa7
	    //connection 요청시 마다 새로운 객체 생성
	    // 현업 ( Connection Pool) > 미리 연결 객체 생성해 놓고 > 가져다 쓰고 반환하는 방식
	    						// 미리 튜브에 바람 넣어놓고 > 사람들이 가져다 쓰는 방식ㅋㅋㅋ 
	    
	    // 복습 (single 복습)
	    // 하나의 연결 객체를 공유해서 사용할 수 없을까?
	    //singleton으로 ....
	    
	}
	
	
	

}
