import java.sql.Connection;
import java.sql.DriverManager;

public class Ex02_Mariadb_Connection {

	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println();


		//loading 된 드라이버를 통해서 Oracle 서버 연결
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb","kosa","1004");
		
		//mysql, oracle ...연결객체 생성 >> 
		System.out.println(conn.isClosed() + "아니 false 연결되어있는데 ");
	}

}
