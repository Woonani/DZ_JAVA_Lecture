package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
1. SimpleController extends HttpServlet 
>> SimpleController  HttpServlet 파일을 상속하고 있어요 
>> SimpleController.java >> 웹에 사용되는 객체를 사용가능 >> 일반 자바파일이 아니라 웹용 자바파일(서블릿) 이라 하자

>> HttpServletRequest request = new HttpServletRequest();
>> 객체가 자동 생성 .... request 객체를 가지고 놀 수 있어요

>> HttpServletResponse response = new HttpServletResponse();
>> 객체가 자동 생성 .... response 객체를 가지고 놀 수 있어요

jsp 파일
주소창에 : http://..../default.jsp

servlet
주소창에 : http://..../SimpleController.java ...(x)

web.xml 파일에서 요청 주소를 설정
[어떤 요청 주소가] 들어오면 SimpleController 컴파일 하고 실행할 거냐 ..정의

web.xml
에서
	<servlet-name>simplecontroller</servlet-name>
  	<url-pattern>/simple</url-pattern>
  	1. http://localhost:8090/WebServlet_1/simple에 요청이 오면
  	2.<servlet-name>simplecontroller</servlet-name>
  	  <url-pattern>/simple</url-pattern> 설정을 근거로 
  	   com 패키지 아래에 있는 com.Simplecontroller.java를 찾아서 컴파일하고 실행합니다.
  	3. 똑같은 요청이 들어오면 실행파일있있는지 보고, 있으면 실행합니다...
  	
서블릿 조건: 일반 java 파일이 extends HttpServlet 상속 >> 웹 쵸청(request), 웹에 대한 응답 (response) 객체 사용
- servlet파일은 url 요청을 바로 할 수 없음. >> 요청에대한 mapping을 해야함 >> xml 또는 annotation

1. web.xml (구방식)
2. @@WebServlet (현재..)    ex)WebServlet("/Simple")이렇게만 쓰면 xml 없이도 맵핑이 가능하다. 




protected void doGet() 함수   // 클라이언트가 get방식으로 요청을 보내면 작동되오록 짜여있고
ex) http://localhost:8090/WebServlet_1/simple    GET방식

protected void doPost() 함수   // 클라이언트가 post방식으로 요청을 보내면 작동되오록 
ex) http://localhost:8090/WebServlet_1/simple    (form 만들고 method=post 지정)
명시적인 호출에 의해서 동작 ..... 일반적인 ....

2개의 함수는 어떤 사건이 발생하면 자동 호출 되도록

EX) Javascript 이벤트 ... 자동 함수 호출 (onload... 사건이 발생하면 핸들러 함수 자동 호출)

doGET() , doPOST()
1.request 객체, response 객체를 가지고 데이터 처리 (받고) , 응답하고 ....

*/
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화");
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 : GET");
		
		//JSP 사용했던 방식과 동일
		
		// 1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 받기 (회원가입, 게시판 글쓰기, 로그아웃)
		String type = request.getParameter("type");
		
		// 3. 로직(업무수행) >> service 수행
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if (type.equals("date")) {
			resultobj = new Date();
		}else {
			resultobj = "invalid String type";
		}
		
		//MVC 패턴 흉내 ...JSP 있는 시대입니다
		// 4. JSP (view)  데이터 출력 할려면 >> servlet 가지고 있는 자원을 >> View에게 전달 (JSP)
		// 결과를 저장 : application, session(scope), request(scope page 한정) 객체 저장 (include, forward)
		// 내가 만든 자원이 모든 페이지에서 필요하지 않다면 ....  request 사용 ... 다른 페이지(forward)
		request.setAttribute("result", resultobj);
		
		// 5. 저장한 결과를 JSP 페이지에 전달 (UI구성)
		// 현재 : webapp > simpleview.jsp
		// 개발 : webapp > WEB-INF > view > board > board.jsp
		
		//System.out.println("result속 : "+ request.getAttribute("result").toString());
		
		// getRequestDispatcher >> view 페이지를 지정합니다
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		
		dis.forward(request, response); // 현재 내가 가지고 있는 request 객체의 주소값을 forward 시킴. parameter로 .
	   
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
