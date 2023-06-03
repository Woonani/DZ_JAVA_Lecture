import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosa.utils.SingletonHelper;

public class Ex07_SingletonHelper {

	public static void main(String[] args) throws SQLException {
		/*
		Connection conn = null;
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		
		Connection conn2 = null;
		conn2 = SingletonHelper.getConnection("oracle"); // 커넥션 할 때마다 같은 객체가 나오길 원함.
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		
		/*
		 *	oracle.jdbc.driver.T4CConnection@45752059
			Oracle
			oracle.jdbc.driver.T4CConnection@45752059
			Oracle
		 */
		
		Connection conn = null;
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		//SingletonHelper.close(conn);
		SingletonHelper.dbClose();
		
		Connection conn2 = null;
		conn2 = SingletonHelper.getConnection("mariadb"); // 커넥션 할 때마다 같은 객체가 나오길 원함.
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		
		/*
		 *  oracle.jdbc.driver.T4CConnection@45752059
			Oracle
			oracle.jdbc.driver.T4CConnection@45752059
			Oracle  // mariadb인데도 oracle 나옴 >> 방법  연결 해제 후 null fh gownrl

		 */
		
	}

}
