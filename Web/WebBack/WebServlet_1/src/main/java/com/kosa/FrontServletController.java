package com.kosa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "여기는 설명을 하는 곳입니다", 
            urlPatterns = { "/action.do" })
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontServletController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		//http://192.168.0.29:8090/WebServlet_1/action.do?cmd=greeting
		
		//1. 한글처리
			 request.setCharacterEncoding("UTF-8");
		//2. 데이터 받기
			 String cmd = request.getParameter("cmd");
		//3. 판단하기(요청) 로직처리
			 String msg="";
			 Message m = null;
			 if(cmd.equals("greeting")) {
				 //java 파일 용이 (DAO , DTO)
				 m = new Message(); // m에 객체 생성하여 담음
				 msg = m.getMessage(cmd); // m에 생성자 함수로 cmd내용 parameter로 보내서 str생성 =>> msg에 담음.
			 }
		
		//4. 데이터 저장
			 request.setAttribute("msg", msg);
			 request.setAttribute("msgobj", m);
		//5. view 페이지 설정
			 //뷰 지정하기 (Dispatcher)
			 RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		//6. view 데이터 전달(forward)
			 dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
	}

}
