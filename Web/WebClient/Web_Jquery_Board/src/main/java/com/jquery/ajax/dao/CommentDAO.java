package com.jquery.ajax.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jquery.ajax.dto.CommentVO;
import com.jquery.ajax.utils.ConnectionHelper;

public class CommentDAO {
  //CRUD => method (select ,insert , update ,delete)
	private static CommentDAO instance = new CommentDAO();
	private static List<CommentVO> commentlist = new ArrayList<CommentVO>();
	// { } , static{ } 초기자
	static{
		for(int k = 0 ; k < 5 ;k++){
			//commentlist.add(new CommentVO(k,k+ "번째 덧글입니다"));
			//0 , 0번쨰 덧글입니다
			//..
			//3 , 3번쨰 덧글입니다
		    //4 , 4번째 덧글입니다
		}
  	   }
	public static CommentDAO getInstance(){
		return instance;
	}
	
	//생성자 private
	public CommentDAO(){}
	
  	public List<CommentVO> getCommentList(int bbsSeq) { 
  		PreparedStatement pstmt = null;
		String sql="select co_no,co_contents,board_no from comment2 where board_no=?";
		List<CommentVO> memolist = null;
		///POOL///////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		ResultSet rs = null;

		try {
			
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsSeq);
			 rs = pstmt.executeQuery();
			memolist = new ArrayList<CommentVO>(); //POINT
			//[new memo()][new memo()][new memo()][new memo()]
			while(rs.next()) {
				CommentVO com = new CommentVO();
				com.setSeq (rs.getInt("co_no"));
				com.setComment(rs.getString("co_contents"));
				com.setBseq(rs.getInt("board_no"));
				
				memolist.add(com);
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			
		ConnectionHelper.close(rs);
		ConnectionHelper.close(pstmt);
		
		ConnectionHelper.close(conn);
		}
		
		return memolist;
  	}
	
  	
  	public int addComment(String comment, int bseq){ 
  		System.out.println("comDAO"+comment.toString());
		int resultrow=0;
		
		PreparedStatement pstmt = null;
		String sql="insert into comment2(co_no, co_contents, board_no) values(co_seq.NEXTVAL,?,?)";
		
		//POOL
		Connection conn = null;


		try {
				//POOL
				conn = ConnectionHelper.getConnection("oracle");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,comment);
				pstmt.setInt(2, bseq);
				
				resultrow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환하기 
		}
				
		return resultrow;
  	}
	
  	public void removeComment(int seq){  //delete   .. DB
  		for(int k =0 ; k <commentlist.size() ; k++){
  			if(commentlist.get(k).getSeq() == seq){
  				commentlist.remove(k);
  			}
  		}
  	}
}






