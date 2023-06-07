package com.jquery.ajax.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.dao.CommentDAO;
import com.jquery.ajax.dto.CommentVO;

public class CommentServiceAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		String comment = request.getParameter("comment");
		int bseq = Integer.parseInt(request.getParameter("bbsSeq"));
		
		ActionForward forward = new ActionForward();
		List<CommentVO> commentlist= null;
		try {
			
			 CommentDAO dao = new CommentDAO();		
	
			 int result = dao.addComment(comment, bseq);
			 
			 if(result > 0 ) {
				System.out.println("com dao result : "+result);
				commentlist= dao.getCommentList(bseq);
				for(CommentVO com : commentlist) {
					
					System.out.println(com.toString());
				}
			 }else {
				 System.out.println("insert 실패");
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}

		Gson gson = new Gson();
        String json = gson.toJson(commentlist);
      
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8"); 
		 //response.getWriter().write(json);
		//request.setAttribute("commentlist", commentlist);
		
		
		return forward;

	}
}
