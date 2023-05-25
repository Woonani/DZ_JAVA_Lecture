<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="java.util.*"%>
<%@page import="kr.or.kosa.dao.EmpDao"%>
<%@page import="kr.or.kosa.util.SingletonHelper"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<% 
	EmpDao dao = new EmpDao();
	List<Emp> emplist = dao.getEmpAllList();
	request.setAttribute("list", emplist);
	System.out.print(emplist);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	
</head>
<body>
	<h3>emp table</h3>
	<table class="table table-striped">
	  <thead>
	    <tr  class="table-primary">
	      <th scope="col">#</th>
	      <th scope="col">empno</th>
	      <th scope="col">ename</th>
	      <th scope="col">job</th>
	      <th scope="col">sal</th>
	      <th scope="col">hiredate</th>
	    </tr>
	  </thead>
	  <tbody>
	  		<c:forEach var="emp" items="${requestScope.list}" varStatus="status">
			    <tr>
			      <th scope="row">${status.count}</th>
			      <td>${emp.empno}</td>
			      <td>${emp.ename}</td>
			      <td>${emp.job}</td>
			      <td>${emp.sal}</td>
			      <td>${emp.hiredate}</td>
			    </tr>
				
			</c:forEach>
	  </tbody>
	</table>
</body>
</html>