import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import kr.or.kosa.utils.SingletonHelper;
import oracle.jdbc.OracleTypes;
/*
create or replace procedure usp_EmpList
(
  p_sal IN number,
  p_cursor OUT SYS_REFCURSOR -- APP 사용하기 타입
)
is
    begin
        open p_cursor 
        for select empno, ename ,sal from emp where sal > p_sal;
    end;

    var out_cursor REFCURSOR
    exec usp_EmpList(2000,:out_cursor)
    print out_cursor;

*/
public class Assignment3_MariaDB_Procedure_Select {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null; 
		ResultSet rs = null;
		
		// 전체조회
		try {
			conn = SingletonHelper.getConnection("mariadb", "super", "1004");
			String sql = "{call usp_EmpList}";
			cstmt = conn.prepareCall(sql);
			rs= cstmt.executeQuery(); 
			
			while(rs.next()) {
				System.out.println(rs.getInt("empno") + "/" + rs.getString("ename") + "/" + rs.getInt("sal"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(cstmt);
		}
		/*
	   */
		
		// 조건 조회
		
	}

}
