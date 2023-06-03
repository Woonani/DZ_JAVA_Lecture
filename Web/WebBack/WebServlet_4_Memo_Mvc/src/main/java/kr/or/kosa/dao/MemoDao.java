//Connection conn= null;  // 여기서 다시 null을 만들어준 셈. 이 클레스 생성자 함수에서 conn을 싱글톤 헬퍼를 한번만 생성하는데
package kr.or.kosa.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import kr.or.kosa.dto.Memo;
import kr.or.kosa.utils.SingletonHelper;

/*
DB연결
CRUD 함수 생성 > memo
1. 전체조회  : select id , email , content from memo
2. 조건조회  : select id , email , content from memo where id=? //제약 id >pk
3. 삽입     : insert into memo(id,email,content) values(?,?,?)
4. 수정     : update memo set email=? , content=? where id=?
5. 삭제     : delete from memo where id=?
알파... LIKE 검색  where email like '%naver%'

자바로 함수를 생성 .... 처리 ... 거의 똑같아요
ArrayList
HashMap
제너릭 ...
*/

public class MemoDao {
	Connection conn = null;
	
	public MemoDao() throws ClassNotFoundException {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	public List<Memo> getMemoList(){

		List<Memo> memoList = new ArrayList<>();
		
		
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			   String sql="select id, email, content from memo";
			   pstmt = conn.prepareStatement(sql);
			   rs = pstmt.executeQuery();
			   //POINT 여러건 데이터 담기 ^^
			   while(rs.next()) {
				   Memo memo = new Memo(); //하나의 row 를 담을 수 있는 DTO 객체 생성
				   memo.setId(rs.getString("id"));
				   memo.setEmail(rs.getString("email"));
				   memo.setContent(rs.getString("content"));
				  
				   memoList.add(memo); //ArrayList 객체 담기 .... 5건  >> Dept 객체 5개 add
			   }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return memoList;
	}
		
		//조건조회 (where id=? : 데이터 1건 보장 : id컬럼 > unique , primary key)
		public Memo getMemoListById(String id) {
			
			//select id, email , content from memo where id=?
			//memo m = new memo();
			//return m
			
			return null;
			
		}
		
		
		//삽입
		//public int insertMemo(String id, String email , String content) parameter 객체 ...
		public int insertMemo(Memo m) {
			
			System.out.println(m.toString());
			int resultrow=0;
			
			PreparedStatement pstmt = null;
			String sql="insert into memo(id,email,content) values(?,?,?)";
			
			try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,m.getId());
					pstmt.setString(2,m.getEmail());
					pstmt.setString(3,m.getContent());
					
					resultrow = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				SingletonHelper.close(pstmt);
			}
					
			return resultrow;
		}
		
		//수정
		public int updateMemo(Memo m) {
			return 0;
		}
		//삭제
		public int deleteMemo(String id) {
			return 0;
		}
		//검색
		public Memo idSearchByEmail(String email) {
			return null;
		}
		//ID 유무 함수
		public String isCheckById(String id) {
		
			String ismemoid=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql="select id from memo where id=?";

			try {
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setString(1, id);
				  		
				  rs = pstmt.executeQuery();
				  if(rs.next()) {
					  //같은 ID 존재
					  ismemoid = "false";
				  }else {
					  //사용가능한 ID
					  ismemoid = "true";
				  }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}
			
			return ismemoid;
			
		}
	
}
