<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL 은 대체  <%= write 대체목적
	
	//자바가 가지는 자원들 ... EL 과 JSTL 못해요
	
	Date today = new Date();
	request.setAttribute("day", today);
	request.setAttribute("day2", today);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 화면 출력 (서버쪽 자원을 ...)</h3>
	<h5>EL은 객체.키이름 으로 자원을 불러온다. </h5>
	EL : ${requestScope.day} <br> 
	<h5>EL은 객체.키이름 에서 객체를 생략 가능하지만 코드의 가독성을 위해 붙여주자. </h5>
		EL : ${day}<br><!--  day 어떤 객체에 담겨있는 거야 (session , request 판단(x)) -->
	EL :data2:${day2}<br>
	EL :${requestScope.day2}<br>
	<!-- 교수님 왜 sessionScope.day2로 하신거지.. -->
</body>
</html>