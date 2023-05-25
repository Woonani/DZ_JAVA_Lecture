package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontBoardController2
 */
@WebServlet(
		description = "게시판 front 컨트롤러 입니다.", 
		urlPatterns = {  "/Board"  }
		)
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontBoardController() {
        super();
        
    }

	// 요청 (동기식) >> doGet , doPost 실행 >> 로직 동일 >> private void doProcess 만들어서 호출 (둘다)
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	// GET 요청이나, POST 요청 둘 다 doProcess 처리
    	System.out.println("클라이언트 요청 방식 : " + method);
    	
    	// 1. 한글처리
    	
    	// 2. 요청받기 (request)
    	
    	// 3. 요청판단 (기준 1.parameter 사용하기 : cmd=value >> cmd 가지는 값에 따라 판단 
    	// ex) http://192.168.0.52:8080/Web/Board?cmd=write&id=wne&content=안녕  글쓰기 >> 이런게 거멘드(cmd)방식
     	// ex) http://192.168.0.52:8080/Web/Board?cmd=lsit   글목록보기 (약속)
    	//				2. URL 주소 사용하기
    	
    	// 4. 결과저장(application, session, request)
    	
    	// 5. View 지정 
    	
    	// 6. View 에게 전달 (결과: session, request) >> forward 방식으로 >> 클라이언트의 주소는 변하기 않고 다른 내용들을 보낼 수 있는 것임.
    	
    	request.setCharacterEncoding("UTF-8");
    	String cmd = request.getParameter("cmd");
    	
    	String viewpage = null;
    	// cmd > null > error.jsp
    	// cmd > boardlist > list.jsp
    	// cmd > boardwrite > write.jsp 서비스
    	if(cmd == null) {
    		viewpage = "/error/error.jsp";
    		
    	}else if(cmd.equals("boardlist")){
    		/*
    		 DB연결 > select > 객체담기
    		 boardDao dao = new boardDao();
    		 List<Board> boardlist = dao.selectBoardList();
    		 request.setAttribute("list", boardlist);
    		 forward > view > jsp > request.getAttribute("lsit");
    		   
    		 */
    		viewpage ="/board/boardlist.jsp";
    		
    	}else if(cmd.equals("boardwrite")) {    		
    		viewpage ="/board/boardwrite.jsp";
    		
    	}else if(cmd.equals("boarddelete")) {
    		viewpage ="/board/boarddelete.jsp";
    		
    	}else if(cmd.equals("login")) {
    		viewpage ="/WEB-INF/views/login/login.jsp"; // 개발 ....
    		
    	}else {
    		viewpage = "/error/error.jsp";

    	}
    		
    	// 결과 저장
    	// 결과를 저장했다고 하고
    	//request.set ...
    	
    	RequestDispatcher dis = request.getRequestDispatcher(viewpage);
    	
    	dis.forward(request, response);
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request, response, "GET");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request, response, "POST");
		
	}

}
