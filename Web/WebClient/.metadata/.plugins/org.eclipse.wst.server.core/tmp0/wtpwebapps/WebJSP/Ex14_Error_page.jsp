<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page errorPage="/error/commonError.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 
			Error(예외상황) >> 특정 처리 페이지 제작
			
			1. 페이지 마다 설정 통해서 에외 페이지 강제 >>   < %@ page errorPage="/error/commonError.jsp
			2. 전역 적인 방법으로 웹 사이트 전체 예외 페이지 강제
			
			실제 개발시에는 오류페이지 보고요 최종 배포시에는 처리......
		
		 -->
		 <% 
		 	String data = request.getParameter("name");
			String data2 = data.toLowerCase(); //null 인경우
		 
		 %>
		 전달받은 내용 : <%=data %>
	</body>
</html>