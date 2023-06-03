<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String id = request.getParameter("ID");
	if(id.equals("hong")){
%>
	<%=id%><img src="images/1.jpg" style="width:100px;height:100px">
<%		
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL & JSTL</h3>
<!-- 
param 객체  >> request.getParameter()
request.getParameter("ID") >>     ${param.ID}
 -->
<c:if test="${param.ID == 'hong'}">
	${param.ID}<img src="images/1.jpg" style="width:100px;height:100px">
</c:if>
<!-- 
http://localhost:8090/WebJSP_EL_JSTL/Ex04_EL_JSTL.jsp?ID=hong&age=100
http://localhost:8090/WebJSP_EL_JSTL/Ex04_EL_JSTL.jsp?ID=hong&age=15
 -->
<hr>
<c:if test="${param.age > 20}" var="result">
	param.value : ${param.age}<br>
</c:if> 
if문을 통해서 var 변수 생성 : ${result}
<!-- 

http://localhost:8090/WebJSP_EL_JSTL/Ex04_JSTL.jsp?ID=hong&age=20
param.value : 21 / if문을 통해서 var 변수 생성 : false
http://localhost:8090/WebJSP_EL_JSTL/Ex04_JSTL.jsp?ID=hong&age=21
param.value : 21 / if문을 통해서 var 변수 생성 : true
 -->
</body>
</html>




