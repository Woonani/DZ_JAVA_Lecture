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
public class Ex12_Oracle_Procedure_Select {

	public static void main(String[] args) {
		Connection conn = null;
		//명령객체
		CallableStatement cstmt = null; // 명령객체 (프로시져)
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "{call usp_EmpList(?,?)}";
			cstmt = conn.prepareCall(sql);
			
			// usp_EmpList(?,?) >> ? input, ? output
			cstmt.setInt(1,  2000); // 첫번째 물음표에 2000을 넣고~
			cstmt.registerOutParameter(2, OracleTypes.CURSOR); // p_cursor OUT SYS_REFCURSOR  //두번째 물을 표에.. 커서 타입을 써줌
			
			boolean result = cstmt.execute();
			
			rs=(ResultSet) cstmt.getObject(2); // 다운 캐스팅 걸어줘야함. rs는 jdbc가 갖고있는 메모리, 왔다갔다 하면서 가져오지 X
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "/" + rs.getString(2) + "/" + rs.getInt(3));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(cstmt);
		}

	}

}
