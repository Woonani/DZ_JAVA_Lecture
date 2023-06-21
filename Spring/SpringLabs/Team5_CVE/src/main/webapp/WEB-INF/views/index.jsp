<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	
	<div>
	
		<form action="customer/getEmpByEmpno.htm" >
        	<input type="number" id="empnumber" name="empno">
       	 	<input type="submit" value="검색">
    	</form>
		
	</div>
	
		<div id="main">
			<c:forEach  var="n" items="${emp}">
							<tr>
								<td class="empno"><a href="customer/detail.htm?empno=${n.empno}">${n.empno}</a></td>
								<td class="ename">${n.ename}</td>
								<td class="job">${n.job}</td>
								<td class="mgr">${n.mgr}</td>
								<td class="hiredate">${n.hiredate}</td>
								<td class="sal">${n.sal}</td>
								<td class="comm">${n.comm}</td>
								<td class="deptno">${n.deptno}</td>
							</tr>
			</c:forEach>
		</div>
		
		
		<a href="customer/insertEmp1.htm">사원 등록</a>
		
	</body>
</html>
