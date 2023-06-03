package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.memoListServiceAction;
import kr.or.kosa.service.memoWriteServiceAction;

@WebServlet("*.do")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public MemoController() {
        super();
       
    }
    // ============ 이거 위에꺼 있어야 하나??
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    		action = new memoWriteServiceAction();
    		forward = action.excute(request, response);
    	}else if(urlcommand.equals("/memoList.do")) {
    		action = new memoListServiceAction();
    		forward = action.excute(request, response);
    		System.out.println("컨트롤러 forward : " + forward);
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
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}


