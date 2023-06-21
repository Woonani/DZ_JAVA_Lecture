<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			
				<c:forEach  var="n" items="${empbyname}">
							<tr>
								<td class="empno"><a href="detail.htm?empno=${n.empno}">${n.empno}</a></td>
								<!-- 여기는 customer/ 쓰면 안댐. why? -->
								<td class="ename">${n.ename}</td>
								<td class="job">${n.job}</td>
								<td class="mgr">${n.mgr}</td>
								<td class="hiredate">${n.hiredate}</td>
								<td class="sal">${n.sal}</td>
								<td class="comm">${n.comm}</td>
								<td class="deptno">${n.deptno}</td>
							</tr>
				</c:forEach>
			
			
</body>
</html>