package com.jquery.ajax.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.dao.BoardDAO;
import com.jquery.ajax.dao.CommentDAO;
import com.jquery.ajax.dto.BoardVO;
import com.jquery.ajax.service.CommentServiceAction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public BoardController() {
        super();  
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	// 1 한글
    	request.setCharacterEncoding("UTF-8");

    	// 2 데이터 받기
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	Action action = null;
    	ActionForward forward=null;
    	
    	// Client 요청
    	if(urlcommand.equals("/memoWrite.do")) {
//    		action = new memoWriteServiceAction();
//    		forward = action.excute(request, response);
    		System.out.println("아직 안만듦");
    	}else if(urlcommand.equals("/boardList.do")) {
    		BoardDAO dao = new BoardDAO();
    		List<BoardVO> boardList =dao.getBoardList();
    		//action = new BoardListServiceAction();
    		 // 응답으로 text를 보낼경우
    		Gson gson = new Gson();
            String json = gson.toJson(boardList);
          
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8"); 
			 response.getWriter().write(json);
    		//forward = action.excute(request, response);
    	}else if(urlcommand.equals("/commentWrite.do")) {
    		System.out.println("commentW 데이터확인 : "+ request.getParameter("comment"));
    		System.out.println("1");
    		CommentDAO dao = new CommentDAO();
    		action = new CommentServiceAction();
    		System.out.println("2");
    		System.out.println(request.getAttribute("commentlist"));
    		System.out.println("3");
    		action.excute(request, response);
    	}
		
		
		/* 분기
  		 * 1. 리스트보여주기 -> /showlist.do -> service -> dao -> getpath
		 * 2. 글쓰기 -> /writememo.do -> service -> getpath
		 */

		if(forward != null) {
    		if(forward.isRedirect()) { //true location.href="" 새로운 페이지 받겠다
    			response.sendRedirect(forward.getPath());
    		}else {
    			//false (forward) >> view 페이지 >> 저장 자원 출력 

    	    	RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    	    	dis.forward(request, response);
    		}
    	}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


