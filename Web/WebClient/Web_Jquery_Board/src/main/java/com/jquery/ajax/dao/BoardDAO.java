package com.jquery.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jquery.ajax.dto.BoardVO;
import com.jquery.ajax.utils.ConnectionHelper;


public class BoardDAO {

	//싱글톤
	private static BoardDAO instance = new BoardDAO();
	
	private static List<BoardVO> boardList2 = new ArrayList<BoardVO>();
	
	public BoardDAO(){}
	
	public static BoardDAO getInstance(){
		return instance;
	}
	static{
		for(int k = 0 ; k < 5; k++){
			boardList2.add(new BoardVO(k,k+" 번쨰 제목",k+" 번째 내용","2017-11-12",k));
		}
	}
	
	//CURD 메서드
	//전제조회 (READ)
	public List<BoardVO> getBoardList(){
		PreparedStatement pstmt = null;
		String sql="select no, title, contents, regdate, hit from board2";
		List<BoardVO> boardList = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
	
		rs = pstmt.executeQuery();
		
		 boardList = new ArrayList<BoardVO>(); //POINT
		//[new memo()][new memo()][new memo()][new memo()]
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("contents"));
			board.setRegdate(rs.getString("regdate"));
			board.setHit(rs.getInt("hit"));
			
			boardList.add(board);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			
			//Pool에게 반환
			ConnectionHelper.close(conn);
			
		}
		
		return boardList;
	}
	
	//데이터 추가(CREATE)
	public void addBoard(String board){
		int size = boardList2.size();
		boardList2.add(new BoardVO(size, board)); //데이터 추가 (글번호 ,글제목)
	}
	
	//데이터 삭제(DELETE)
	public void removeBoard(int seq){
		for(int k=0 ;  k < boardList2.size() ; k++){
			if(boardList2.get(k).getSeq() == seq){
				boardList2.remove(k);
				break;
			}
		}
	}
	
	//데이터 수정(UPDATE)
	public boolean modifyBoard(BoardVO board){
		int seq = board.getSeq();
		
		for(int k = 0 ; k < boardList2.size() ; k++){
			if(boardList2.get(k).getSeq() == seq){
				boardList2.set(k,board);
				
				//아래 처럼 해도 되요
				//boardList.get(k).setTitle(board.getTitle());
				//boardList.get(k).setContent(board.getContent());
				return true;
			}
		}
		return false;
	}

}
