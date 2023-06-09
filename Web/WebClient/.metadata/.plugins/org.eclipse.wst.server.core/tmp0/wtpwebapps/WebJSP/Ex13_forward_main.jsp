<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 

	 [요청에 대한 흐름 제어]
	 
	 1. include (공통 디자인)
	 2. forward (중계자 : 경찰서 112상황실 통제권한)
	 
	 공통점 : request객체를 공유한다 (^^!)
	 차이점 : 제어권 : include(제어권을 다시 가지고 온다)
	               foward (제어권을 넘겨준다) >> spring 에서 ....(servlet) >>요청마다 다른 서비스
	 			   POINT) [요청주소]는 [동일]한데 [다른 page]의 내용을 서비스 
     ex)
     http://192.168.0.29:8090/WebJSP/_forward.jsp?code=B
     http://192.168.0.29:8090/WebJSP/_forward.jsp?code=C
     
	 1. 클라이언트가 요청한 page >> _forward.jsp
	 2. 클랑이언트가 받는 page 정보는 > A.jsp or  B.jsp or C.jsp
	 
	 원리: Buffer 주인 > _forward.jsp > Buffer는 _forward 내용을 담아야 하는데
	     forward를 만나면 > 주인 배신 > Buffer 비워버리고 > 비워진 Buffer > forward 된 page 내용 
	     > Client 서비스 
	 

	*/

	 String code = request.getParameter("code");
     String viewurl = null;
     
     //논리
     if(code.equals("A")){
    	 viewurl = "/forward/A.jsp";
     }else if(code.equals("B")){
    	 viewurl = "/forward/B.jsp";
     }else if(code.equals("C")){
    	 viewurl = "/forward/C.jsp";
     }
    	 
    	 

%>

<jsp:forward page="<%=viewurl %>"></jsp:forward>

<!-- 
forward 가지고 있는 페이지는 아래있는 내용이 의미 없다
"<jsp:forward page=..................." 이거 안쓰면 페이지 fowarding도 안되고 아래 페이지 보임.
Buffer 비우고 그 Buffer에 forward페이지의 내용을 담아요
 -->


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>나는 나는 forward MAIN 페이지</h3>
	</body>
</html>