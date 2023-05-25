<%@page import="java.sql.Connection"%>
<%@page import="kr.or.kosa.utils.SingletonHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
Connection conn = null;
conn = SingletonHelper.getConnection("oracle");
System.out.println(conn.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= conn.isClosed() %>
</body>
</html>
