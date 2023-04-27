
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.or.kosa.utils.ConnectionHelper;
import kr.or.kosa.utils.SingletonHelper;

/* emp 테이블 생성
CREATE TABLE `emp` (
	`id` INT NOT NULL,
	`name` VARCHAR(50) NULL DEFAULT '',
	`job` VARCHAR(50) NULL DEFAULT '',
	`deptno` INT NULL DEFAULT NULL
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='team5';
*/
/* emp테이블   PK추가
ALTER TABLE `emp`
	ADD PRIMARY KEY (`id`);
*/
/* dept 테이블 생성
CREATE TABLE `D` (
	`deptno` INT NOT NULL,
	`dname` VARCHAR(50) NULL,
	`mngid` INT NULL
)
COLLATE='utf8_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='team5';
*/
/* dept 테이블에 PK추가
ALTER TABLE `dept`
	ADD PRIMARY KEY (`deptno`);
*/
/* emp 테이블의 dept컬럼에   FK추가
ALTER TABLE `emp`
	ADD CONSTRAINT `deptno` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`) ON UPDATE NO ACTION ON DELETE NO ACTION;

*/
public class Assignment2_MariaDB_CRUD {

	public static void main(String[] args) {
		//INSERT
		//insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?,?,?,?,?,?,?,?)
		
		//UPDATE
		//update emp set ename =?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=?
		//where empno=?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
		// insert 1 : dept table
		try {
			conn = ConnectionHelper.getConnection("mariadb", "root", "1004");
//			conn = ConnectionHelper.getConnection("mariadb", "team5", "root", "1004");
			
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?,?,?,?,?,?,?,?)";
//			String sql = "insert into dept(deptno, dname, mngid) values(?,?,?)";
			pstmt = conn.prepareStatement(sql); // 미리 컴파일
			// parameter 설정해서 보내기
			pstmt.setInt(1, 111);
			pstmt.setString(2, "강호동");
			pstmt.setString(3, "MC");
			pstmt.setInt(4, 0 ); 
			pstmt.setString(5, "sysdate" ); 
			pstmt.setInt(6, 1000 ); 
			pstmt.setInt(7, 100 ); 
			pstmt.setInt(8, 10 ); 
//			pstmt.setInt(3, null ); // null : 널값 넣는 법??

			// 실행
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("update row count : " + row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		 */
		
		
		
		
		/*
		
		// update  1  dept table
				try {
					conn = ConnectionHelper.getConnection("mariadb", "team5", "root", "1004");
					

					String sql = "update dept set mngid=? where deptno=?";
//					String sql = "update dept set dname=?, mngid=? where deptno=?";
					pstmt = conn.prepareStatement(sql); // 미리 컴파일
					// parameter 설정해서 보내기
					pstmt.setInt(1, 125); // where문을 먼저 읽고 그런 거 상관없이 그냥 앞에서 부터
					pstmt.setInt(2, 20);

					
					// 실행
					int row = pstmt.executeUpdate();
					if(row>0) {
						System.out.println("update row count : " + row);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					SingletonHelper.close(pstmt);
				}
*/
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("mariadb");
			String sql = "select ename, job, mgr, hiredate, sal, comm, deptno from emp where empno = ?"; // where empno = 111
			
			pstmt = conn.prepareStatement(sql); // pstmt만들때 미리 컴파일 쿼리를 ....
			// 실행하려는 쿼리는 DB서버가 (공유풀)에 가지고 있음
			
			
			Scanner sc = new Scanner(System.in);
			int empno = Integer.parseInt(sc.nextLine());
			
			//where empno = ?
			pstmt.setInt(1, empno);  // where deptno = 30을 보내놓음
			
			rs = pstmt.executeQuery(); // parameter 값만 서버 전달 // 프리페어에서 미리 쿼리문을 보내서 컴파일 시켜놔서 문장(sql) 안 보내고 파라미터 값만 서버에 전달 >> 훨씬 편하다
			
			// 공식같은 로직
			// 데이터 1건 or 1건 이상 or 없는 경우
			if(rs.next()) {
				// 1건 또는 그 이상
				do {
					System.out.println(rs.getString(1) + " / " + rs.getString(2) + " / " + 
				rs.getInt(3) + " / " + rs.getString(4)+" / " +	rs.getInt(5)+" / " +	rs.getInt(6)+" / " +	rs.getInt(7));
				}while(rs.next());
			}else { // else를 탄다는 것은 데이터 없는것!
				System.out.println("조회된 데이터가 없습니다.");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			// 싱글톤은 close()하지 않아요 (App 살아있는 동안 같은 운명)
		}
	}

}
